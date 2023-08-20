/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.gerador;

/**
 *
 * @author maye
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeradorC extends LABaseVisitor<Void>{
    
    StringBuilder saida;
    Escopos escopos;

    GeradorC() {
        saida = new StringBuilder();
        this.escopos = new Escopos();
    }

    @Override
    public Void visitPrograma(LAParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        if (ctx.declaracoes() != null) {
            visitDeclaracoes(ctx.declaracoes());
            saida.append("\n");
        }
        saida.append("int main() {\n");
        visitCorpo(ctx.corpo());
        saida.append("return 0;\n");
        saida.append("}\n");
        return null;
    }

    //    : 'procedimento' IDENT '(' parametros? ')' declaracao_local* cmd* 'fim_procedimento'
    //    | 'funcao' IDENT '(' parametros? ')' ':' tipo_estendido declaracao_local* cmd* 'fim_funcao'
    @Override
    public Void visitDeclaracao_global(LAParser.Declaracao_globalContext ctx) {
        String start = ctx.start.getText();
        TiposLa.Tipos tipoRetorno = TiposLa.INVALIDO;
        if (start.equals("procedimento")) {
            saida.append("void ");

            escopos.criarNovoEscopo(null);
        } else {
            visitTipo_estendido(ctx.tipo_estendido());
            saida.append(" ");

            tipoRetorno = LaSemanticoUtils.verificarTipo(escopos, ctx.tipo_estendido());
            escopos.criarNovoEscopo(LaSemanticoUtils.
                    verificarTipo(escopos, ctx.tipo_estendido()));
        }

        saida.append(ctx.IDENT()).append(" (");
        if (ctx.parametros() != null) {
            visitParametros(ctx.parametros());
        }
        ctx.declaracao_local().forEach(this::visitDeclaracao_local);
        saida.append(") {\n");

        ctx.cmd().forEach(this::visitCmd);
        saida.append("}\n");

        escopos.sairEscopo();

        List<TiposLa.Tipos> tiposParametros = new ArrayList<>();
        // checar os parametros
        for (var parametro : ctx.parametros().parametro()) {
            for (var pid : parametro.identificador()) {
                String strPid = pid.getText();
                if (escopos.verificarIdent(strPid) != null) {
                    // TODO: erro - nome de parametro já declarado
                    LaSemanticoUtils.adicionarErroSemantico(
                            pid.start,
                            String.format(Mensagens.IDENTIFICADOR_JA_DECLARADO, strPid));
                } else {
                    TiposLa.Tipos tipoParametro = LaSemanticoUtils.verificarTipo(escopos, parametro.tipo_estendido());
                    tiposParametros.add(tipoParametro);
                    escopos.obterEscopoAtual().adicionar(strPid, tipoParametro);
                }
            }
        }

        TiposLa.Tipos tipo;
        if (start.equals("procedimento")) {
            tipo = new TiposLa.Procedimento(tiposParametros);
        } else { // funcao
            tipo = new TiposLa.Funcao(tiposParametros, tipoRetorno);
        }
        escopos.obterEscopoAtual().adicionar(ctx.IDENT().getText(), tipo);

        return null;
    }

    @Override
    public Void visitParametro(LAParser.ParametroContext ctx) {
        TiposLa.Tipos tipo = LaSemanticoUtils.verificarTipo(escopos, ctx.tipo_estendido());
        for (var id : ctx.identificador()) {
            String strId = id.getText();

            visitTipo_estendido(ctx.tipo_estendido());
            saida.append(" ");
            if (tipo == TiposLa.LITERAL) {
                saida.append("*");
            }
            saida.append(strId);

            escopos.obterEscopoAtual().adicionar(strId, tipo);
        }
        return null;
    }

    @Override
    public Void visitDeclaracao_local(LAParser.Declaracao_localContext ctx) {
        String start = ctx.start.getText();
        if (start.equals("declare")) {
            visitVariavel(ctx.variavel());
        } else if (start.equals("constante")) {
            visitTipo_basico(ctx.tipo_basico());
            saida.append(" ")
                    .append(ctx.IDENT());


            if (ctx.tipo_basico().getText().equals("literal")) {
                saida.append("[]");
            }
            saida.append(" = ")
                    .append(ctx.valor_constante().getText())
                    .append(";\n");

            String strId = ctx.IDENT().getText();
            TiposLa.Tipos tipoId = LaSemanticoUtils.verificarTipo(ctx.tipo_basico());
            escopos.obterEscopoAtual().adicionar(strId, tipoId);
        } else {
            String strId = ctx.IDENT().getText();

            saida.append("typedef ");
            visitTipo(ctx.tipo());
            saida.append(" ")
                    .append(strId)
                    .append(";\n");

            if (ctx.tipo().start.getText().equals("registro")) {
                //extração dos campos
                Map<String, TiposLa.Tipos> campos = new HashMap<>();
                for (var variavel : ctx.tipo().registro().variavel()) {
                    TiposLa.Tipos tipoVar = LaSemanticoUtils.verificarTipo(escopos, variavel.tipo());
                    for (var varId : variavel.identificador()) {
                        // TODO: Talvez seja preciso mudar a gramática para não aceitar pontos
                        String idVar = varId.ident1.getText();
                        if (varId.dimensao() != null && !varId.dimensao().exp_aritmetica().isEmpty()) {
                            campos.put(idVar, new TiposLa.Arranjo(tipoVar));
                        } else {
                            campos.put(idVar, tipoVar);
                        }
                    }
                }
                escopos.obterEscopoAtual().adicionar(strId, new TiposLa.Registro(campos));
            }
        }


        return null;
    }

    @Override
    public Void visitCmd(LAParser.CmdContext ctx) {

        return super.visitCmd(ctx);
    }

    @Override
    public Void visitTipo_basico(LAParser.Tipo_basicoContext ctx) {
        String strTipo = ctx.getText();
        switch (strTipo) {
            case "literal":
                saida.append("char");
                break;
            case "logico":
            case "inteiro":
                saida.append("int");
                break;
            default: // real
                saida.append("float");
                break;
        }
        return null;
    }

    @Override
    public Void visitVariavel(LAParser.VariavelContext ctx) {
        visitTipo(ctx.tipo());
        saida.append(" ");

        String start = ctx.tipo().start.getText();
        String ids = ctx.identificador()
                .stream().map(id -> {
                    if (start.equals("^")) {
                        return "*" + id.getText();
                    } else if (start.equals("literal")) {
                        return id.getText() + "[80]";
                    } else {
                        return id.getText();
                    }
                })
                .collect(Collectors.joining(", "));
        saida.append(ids);

        saida.append(";\n");

        TiposLa.Tipos tipo = LaSemanticoUtils.verificarTipo(escopos, ctx.tipo());
        for (var identificador : ctx.identificador()) {
            String strId = identificador.IDENT(0).getText();
//            var indices = identificador.dimensao().exp_aritmetica();

//            for (int i = indices.size() - 1; i >= 0; i--) {
//                var indice = indices.get(i);
//                TiposLa.Tipos tipoIndice = LaSemanticoUtils.verificarTipo(escopos, indice);
//                if (tipoIndice != TiposLa.INTEIRO) {
//                    tipo = TiposLa.INVALIDO;
//                } else {
//                    tipo = new TiposLa.Arranjo(tipo);
//                }
//            }

            escopos.obterEscopoAtual().adicionar(strId, tipo);
        }

        return null;
    }

    @Override
    public Void visitRegistro(LAParser.RegistroContext ctx) {
        saida.append("struct {\n");
        ctx.variavel().forEach(this::visitVariavel);
        saida.append("}");
        return null;
    }

    @Override
    public Void visitTipo_basico_ident(LAParser.Tipo_basico_identContext ctx) {
        if (ctx.tipo_basico() != null) {
            visitTipo_basico(ctx.tipo_basico());
        } else {
            saida.append(ctx.IDENT().getText());
        }
        return null;
    }

    @Override
    public Void visitCmdLeia(LAParser.CmdLeiaContext ctx) {
        for (int i = 0; i < ctx.identificador().size(); i++) {
            TiposLa.Tipos tipo = LaSemanticoUtils
                    .verificarTipo(escopos, ctx.identificador(i));

            if (tipo == TiposLa.LITERAL) {
                saida.append("gets(x);\n");
            } else {


                saida.append("scanf(");


                if (tipo == TiposLa.INTEIRO) {
                    saida.append("\"%d\"");
                } else if (tipo == TiposLa.REAL) {
                    saida.append("\"%f\"");
                }

                saida.append(", ");

                if (ctx.OP_PONTEIRO(i) == null) {
                    saida.append("&");
                }
                saida.append(ctx.identificador(i).getText());
                saida.append(");\n");
            }

        }
        return null;
    }

    @Override
    public Void visitCmdEscreva(LAParser.CmdEscrevaContext ctx) {
        for (int i = 0; i < ctx.expressao().size(); i++) {
            saida.append("printf(");

            TiposLa.Tipos tipo = LaSemanticoUtils
                    .verificarTipo(escopos, ctx.expressao(i));

            if (tipo instanceof TiposLa.Funcao) {
                tipo = ((TiposLa.Funcao) tipo).retorno;
            }
            if (tipo == TiposLa.INTEIRO) {
                saida.append("\"%d\"");
            } else if (tipo == TiposLa.REAL) {
                saida.append("\"%f\"");
            } else if (tipo == TiposLa.LITERAL) {
                saida.append("\"%s\"");
            }

            saida.append(", ");

            saida.append(ctx.expressao(i).getText());
            saida.append(");\n");
        }
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(LAParser.CmdAtribuicaoContext ctx) {
        TiposLa.Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.expressao());
        if (tipoExp == TiposLa.LITERAL) {
            saida.append("strcpy(")
                    .append(ctx.identificador().getText())
                    .append(", ");
            visitExpressao(ctx.expressao());
            saida.append(");\n");
        } else {
            if (ctx.start.getText().equals("^")) {
                saida.append("*");
            }
            saida.append(ctx.identificador().getText())
                    .append(" = ");
            visitExpressao(ctx.expressao());
            saida.append(";\n");
        }
        return null;
    }

    @Override
    public Void visitExpressao(LAParser.ExpressaoContext ctx) {
        visitTermo_logico(ctx.termoLog1);
        for (var termo :
                ctx.termosLog) {
            saida.append(" || ");
            visitTermo_logico(termo);
        }
        return null;
    }

    @Override
    public Void visitTermo_logico(LAParser.Termo_logicoContext ctx) {
        visitFator_logico(ctx.fatorLog1);
        for (var fator :
                ctx.fatoresLog) {
            saida.append(" && ");
            visitFator_logico(fator);
        }
        return null;
    }

    @Override
    public Void visitFator_logico(LAParser.Fator_logicoContext ctx) {
        if (ctx.start.getText().equals("nao")) {
            saida.append("!");
            visitParcela_logica(ctx.parcela_logica());

        } else {
            visitParcela_logica(ctx.parcela_logica());
        }
        return null;
    }

    @Override
    public Void visitParcela_logica(LAParser.Parcela_logicaContext ctx) {
        if (ctx.exp_relacional() != null) {
            visitExp_relacional(ctx.exp_relacional());
        } else if (ctx.start.getText().equals("verdadeiro")) {
            saida.append("1");
        } else {
            saida.append("0");
        }
        return null;
    }

    @Override
    public Void visitExp_relacional(LAParser.Exp_relacionalContext ctx) {
        visitExp_aritmetica(ctx.expArit1);
        if (ctx.op_relacional() != null) {
            String op = ctx.op_relacional().getText();
            if (op.equals("<>")) {
                saida.append(" != ");
            } else if (op.equals("=")) {
                saida.append(" == ");
            } else {
                saida.append(" ").append(op).append(" ");
            }
            visitExp_aritmetica(ctx.expArit2);
        }

        return null;
    }

    @Override
    public Void visitExp_aritmetica(LAParser.Exp_aritmeticaContext ctx) {
        visitTermo(ctx.termo1);
        for (int i = 0; i < ctx.termos.size(); i++) {
            saida.append(" ")
                    .append(ctx.operadores.get(i).getText())
                    .append(" ");
            visitTermo(ctx.termos.get(i));
        }
        return null;
    }

    @Override
    public Void visitTermo(LAParser.TermoContext ctx) {
        visitFator(ctx.fator1);
        for (int i = 0; i < ctx.fatores.size(); i++) {
            saida.append(" ")
                    .append(ctx.OP2(i).getText())
                    .append(" ");
            visitFator(ctx.fatores.get(i));
        }
        return null;
    }

    @Override
    public Void visitFator(LAParser.FatorContext ctx) {
        visitParcela(ctx.parcela1);
        for (int i = 0; i < ctx.parcelas.size(); i++) {
            saida.append(" % ");
            visitParcela(ctx.parcelas.get(i));
        }
        return null;
    }

    @Override
    public Void visitParcela(LAParser.ParcelaContext ctx) {
        if (ctx.parcela_unario() != null) {
            if (ctx.opUnar != null) {
                saida.append("-");
            }
            visitParcela_unario(ctx.parcela_unario());
        } else {
            visitParcela_nao_unario(ctx.parcela_nao_unario());
        }
        return null;
    }

    @Override
    public Void visitParcela_unario(LAParser.Parcela_unarioContext ctx) {
        if (ctx.start.getText().equals("^")) {
            saida.append("*")
                    .append(ctx.identificador().getText());
        } else if (ctx.expressaoParam != null) {
            saida.append("(");
            visitExpressao(ctx.expressaoParam);
            saida.append(")");
        } else if (ctx.IDENT() != null) {
            saida.append(ctx.IDENT().getText())
                    .append("(");
            for (int i = 0; i < ctx.expressoes.size(); i++) {
                visitExpressao(ctx.expressoes.get(i));
                if (i == ctx.expressoes.size() - 1) {
                    saida.append(", ");
                }
            }
            saida.append(")");
        } else {
            saida.append(ctx.getText());
        }
        return null;
    }

    @Override
    public Void visitParcela_nao_unario(LAParser.Parcela_nao_unarioContext ctx) {
        saida.append(ctx.getText());
        return null;
    }

    @Override
    public Void visitCmdSe(LAParser.CmdSeContext ctx) {
        saida.append("if (");
        visitExpressao(ctx.expressao());
        saida.append(") {\n");
        ctx.cmdsEntao.forEach(this::visitCmd);
        if (!ctx.cmdsSenao.isEmpty()) {
            saida.append("} else {\n");
            ctx.cmdsSenao.forEach(this::visitCmd);
        }
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdCaso(LAParser.CmdCasoContext ctx) {
        saida.append("switch (");
        visitExp_aritmetica(ctx.exp_aritmetica());
        saida.append(") {\n");
        visitSelecao(ctx.selecao());

        if (!ctx.cmd().isEmpty()) {
            // caso padrão
            saida.append("default:\n");
            ctx.cmd().forEach(this::visitCmd);
        }
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitItem_selecao(LAParser.Item_selecaoContext ctx) {
        for (var intervalo : ctx.constantes().numero_intervalo()) {
            int inicio = Integer.parseInt(intervalo.numInterIni.getText());
            inicio = intervalo.opUnarInic != null ? -1 * inicio : inicio;
            int fim = inicio;
            if (intervalo.numInterFim != null) {
                fim = Integer.parseInt(intervalo.numInterFim.getText());
                fim = intervalo.opUnarFim != null ? -1 * fim : fim;
            }

            for (int i = inicio; i <= fim; i++) {
                saida.append("case ").append(i).append(":\n");
            }
        }

        ctx.cmd().forEach(this::visitCmd);
        saida.append("break;\n");
        return null;
    }

    @Override
    public Void visitCmdPara(LAParser.CmdParaContext ctx) {
        saida.append("for (")
                .append(ctx.IDENT().getText())
                .append(" = ");
        visitExp_aritmetica(ctx.expParaIni);
        saida.append("; ")
                .append(ctx.IDENT().getText())
                .append(" <= ");
        visitExp_aritmetica(ctx.expParaFim);
        saida.append("; ")
                .append(ctx.IDENT().getText())
                .append("++) {\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("}\n");

        return null;
    }

    @Override
    public Void visitCmdEnquanto(LAParser.CmdEnquantoContext ctx) {
        saida.append("while (");
        visitExpressao(ctx.expressao());
        saida.append(") {\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("}\n");
        return null;
    }

    @Override
    public Void visitCmdFaca(LAParser.CmdFacaContext ctx) {
        saida.append("do {\n");
        ctx.cmd().forEach(this::visitCmd);
        saida.append("} while (");
        visitExpressao(ctx.expressao());
        saida.append(");\n");
        return null;
    }

    @Override
    public Void visitCmdChamada(LAParser.CmdChamadaContext ctx) {
        saida.append(ctx.IDENT().getText())
                .append("(");
        for (int i = 0; i < ctx.expressao().size(); i++) {
            visitExpressao(ctx.expressao(i));
            if (i != ctx.expressao().size()-1) {
                saida.append(", ");
            }
        }
        saida.append(");\n");
        return null;
    }

    @Override
    public Void visitCmdRetorne(LAParser.CmdRetorneContext ctx) {
        saida.append("return ");
        visitExpressao(ctx.expressao());
        saida.append(";\n");
        return null;
    }
}