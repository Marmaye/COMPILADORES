/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.TiposLa.Tipos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maye
 */

//Classe para fazer as visitas em cada parte do programa criado usando a linguagem LA
public class LaSemantico extends LaSemanticoBaseVisitor<Void>{
    private final Escopos escopos;

    //Cria uma nova pilha de escopos
    LaSemantico() {
        escopos = new Escopos();
    }

    //Visita contexto global do programa
    @Override
    public Void visitPrograma(LaSemanticoParser.ProgramaContext ctx) {
        escopos.init();
        return super.visitPrograma(ctx);
    }

    //Visita as declarações locais do programa, verificando se as variáveis foram declaradas corretamente
    @Override
    public Void visitDeclaracao_local(LaSemanticoParser.Declaracao_localContext ctx) {
        String start = ctx.start.getText();
        
        if (start.equals("declare")) {
            //verificação da declaração de variáveis
            visitVariavel(ctx.variavel());
        } 
        else if (start.equals("constante")) {
            
            //verificação da declação de constantes
            String strId = ctx.IDENT().getText();
            TiposLa.Tipos tipoId = LaSemanticoUtils.verificarTipo(ctx.tipo_basico());
            Tipos tipoValor = LaSemanticoUtils.verificarTipo(ctx.valor_constante());

            if (tipoId != tipoValor) { //Erro de atribuição não compatível
                LaSemanticoUtils.adicionarErroSemantico(
                        ctx.IDENT().getSymbol(),
                        String.format(Mensagens.ATRIBUICAO_NAO_COMPATIVEL, strId)
                );

            }
            
            //Adiciona escopo na pilha de escopos
            escopos.obterEscopoAtual().adicionar(strId, tipoId);

        } else {
            
            // verificação da declaração de tipos
            String strId = ctx.IDENT().getText();
            EntradaTabelaSimbolos etds = escopos.verificarIdent(strId);
            if (etds != null) {
                //identificador já declarado
                LaSemanticoUtils.adicionarErroSemantico(ctx.IDENT().getSymbol(),
                        String.format(Mensagens.IDENTIFICADOR_JA_DECLARADO, strId));
            }

            if (ctx.tipo().start.getText().equals("registro")) {
                // verificação da declaração de registro
                Map<String, Tipos> campos = new HashMap<>();
                for (var variavel : ctx.tipo().registro().variavel()) {
                    Tipos tipoVar = LaSemanticoUtils.verificarTipo(escopos, variavel.tipo());
                    for (var varId : variavel.identificador()) {
                        String idVar = varId.ident1.getText();
                        if (campos.containsKey(idVar)) {
                            // identificador já declarado
                            LaSemanticoUtils.adicionarErroSemantico(
                                    ctx.IDENT().getSymbol(),
                                    String.format(
                                            Mensagens.IDENTIFICADOR_JA_DECLARADO,
                                            idVar)
                            );
                        }
                        if (varId.dimensao() != null && !varId.dimensao().exp_aritmetica().isEmpty()) {
                            campos.put(idVar, new TiposLa.Arranjo(tipoVar));
                        } else {
                            campos.put(idVar, tipoVar);
                        }
                    }
                }
                escopos.obterEscopoAtual()
                        .adicionar(ctx.IDENT().getText(), new TiposLa.Registro(campos));
            }
        }
        return null;
    }

    //Visita as variáveis 
    @Override
    public Void visitVariavel(LaSemanticoParser.VariavelContext ctx) {
        Tipos tipo = LaSemanticoUtils.verificarTipo(escopos, ctx.tipo());

        if (tipo == TiposLa.INVALIDO) {

            //erro de tipo inválido
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.tipo().start,
                    String.format(Mensagens.TIPO_NAO_DECLARADO, ctx.tipo().getText()));
        }

        for (var identificador : ctx.identificador()) {
            EntradaTabelaSimbolos etds = escopos.verificarIdent(identificador.getText());
            if (etds != null) {
                //erro de identificador já existe
                LaSemanticoUtils.adicionarErroSemantico(identificador.IDENT(0).getSymbol(),
                        String.format(
                                Mensagens.IDENTIFICADOR_JA_DECLARADO,
                                identificador.getText()));

            }

            String id = identificador.IDENT(0).getText();
            var indices = identificador.dimensao().exp_aritmetica();
            //Verifica erros nos índices das expressões aritméticas
            for (int i = indices.size() - 1; i >= 0; i--) {
                var indice = indices.get(i);
                Tipos tipoIndice = LaSemanticoUtils.verificarTipo(escopos, indice);
                if (tipoIndice != TiposLa.INTEIRO) {
                    tipo = TiposLa.INVALIDO;
                } else {
                    tipo = new TiposLa.Arranjo(tipo);
                }
            }

            if (etds == null) {
                escopos.obterEscopoAtual().adicionar(id, tipo);
            }
        }

        return null;
    }

    //Visita declaração global
    @Override
    public Void visitDeclaracao_global(LaSemanticoParser.Declaracao_globalContext ctx) {
        Tipos tipo;

        String start = ctx.start.getText();
        String identificador = ctx.IDENT().getText();
        Tipos tipoRetorno = TiposLa.INVALIDO;
        
        if (start.equals("procedimento")) {
            //cria escopo de procedimento
            escopos.criarNovoEscopo(null);
        } 
        else { // escopo de função
            tipoRetorno = LaSemanticoUtils.verificarTipo(escopos, ctx.tipo_estendido());
            escopos.criarNovoEscopo(tipoRetorno);
        }

        List<Tipos> tiposParametros = new ArrayList<>();
        
        // checar os parametros
        for (var parametro : ctx.parametros().parametro()) {
            for (var pid : parametro.identificador()) {
                String strPid = pid.getText();
                
                if (escopos.verificarIdent(strPid) != null) {
                    //nome de parametro já declarado
                    LaSemanticoUtils.adicionarErroSemantico(
                            pid.start,
                            String.format(Mensagens.IDENTIFICADOR_JA_DECLARADO, strPid));
                } 
                else {
                    Tipos tipoParametro = LaSemanticoUtils.verificarTipo(escopos, parametro.tipo_estendido());
                    tiposParametros.add(tipoParametro);
                    escopos.obterEscopoAtual().adicionar(strPid, tipoParametro);
                }
            }
        }

        if (start.equals("procedimento")) { //procedimento
            tipo = new TiposLa.Procedimento(tiposParametros);
        } 
        else { // funcao
            tipo = new TiposLa.Funcao(tiposParametros, tipoRetorno);
        }

        ctx.declaracao_local().forEach(this::visitDeclaracao_local);

        ctx.cmd().forEach(this::visitCmd);

        escopos.sairEscopo();

        // adiciona escopo
        escopos.obterEscopoAtual().adicionar(identificador, tipo);

        return null;
    }

    //Visita comando se
    @Override
    public Void visitCmdSe(LaSemanticoParser.CmdSeContext ctx) {
        Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.expressao());
        ctx.cmd().forEach(this::visitCmd);
        return null;
    }

    //Visita comando caso
    @Override
    public Void visitCmdCaso(LaSemanticoParser.CmdCasoContext ctx) {
        Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.exp_aritmetica());
        if (tipoExp != TiposLa.INTEIRO) {
            // TODO: Algum erro
        }

//        ctx.selecao().item_selecao().forEach(this::visitItem_selecao);

        ctx.cmd().forEach(this::visitCmd);

        return null;
    }
    
    
    //Visita comando para
    @Override
    public Void visitCmdPara(LaSemanticoParser.CmdParaContext ctx) {
        EntradaTabelaSimbolos etds = escopos.verificarIdent(ctx.IDENT().getText());
        if (etds == null) {
            //variavel nao declarada
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.IDENT().getSymbol(),
                    String.format(Mensagens.IDENTIFICADOR_NAO_DECLARADO, ctx.IDENT()));
        }

        ctx.cmd().forEach(this::visitCmd);

        return null;
    }

    //Visita comando enquanto
    @Override
    public Void visitCmdEnquanto(LaSemanticoParser.CmdEnquantoContext ctx) {
        visitExpressao(ctx.expressao());
        Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.expressao());
        ctx.cmd().forEach(this::visitCmd);
        return null;
    }

    //Visita comando faça
    @Override
    public Void visitCmdFaca(LaSemanticoParser.CmdFacaContext ctx) {
        visitExpressao(ctx.expressao());
        Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.expressao());
        if (tipoExp != TiposLa.LOGICO) {
            // TODO: Algum erro
        }

        ctx.cmd().forEach(this::visitCmd);
        return null;
    }

    //Visita comando atribuição
    @Override
    public Void visitCmdAtribuicao(LaSemanticoParser.CmdAtribuicaoContext ctx) {
        Tipos tipoId = LaSemanticoUtils.verificarTipo(escopos, ctx.identificador());

        if (tipoId == TiposLa.INVALIDO) {
            // variavel não declarada
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.identificador().start,
                    String.format(
                            Mensagens.IDENTIFICADOR_NAO_DECLARADO,
                            ctx.identificador().getText()));
        } else if (ctx.OP_PONTEIRO() != null) {
            if (tipoId instanceof TiposLa.Ponteiro) {
                tipoId = ((TiposLa.Ponteiro) tipoId).tipo;
            } else {
                tipoId = TiposLa.INVALIDO;
            }
        }

        Tipos tipoExp = LaSemanticoUtils.verificarTipo(escopos, ctx.expressao());

        if (tipoId == TiposLa.REAL && tipoExp == TiposLa.INTEIRO) {
            // ok
        } else if (tipoId instanceof TiposLa.Ponteiro && tipoExp == TiposLa.ENDERECO) {

        } else if (tipoId != tipoExp && tipoId != TiposLa.INVALIDO) {
            // Não atribuir se a variavel não existe
            // atribuicao incompativel
            String strId = ctx.identificador().getText();
            strId = ctx.start.getText().equals("^") ? "^" + strId : strId;
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.identificador().start,
                    String.format(
                            Mensagens.ATRIBUICAO_NAO_COMPATIVEL,
                            strId));
        }

        return null;
    }

    //Visita os identificadores
    @Override
    public Void visitIdentificador(LaSemanticoParser.IdentificadorContext ctx) {
        EntradaTabelaSimbolos etds = escopos.verificarIdent(ctx.IDENT(0).getText());
        Tipos tipoId = TiposLa.INVALIDO;
        if (etds != null) {
            tipoId = etds.tipo;
            if (tipoId instanceof TiposLa.Registro) {
                for (int i = 1; i < ctx.IDENT().size(); i++) {
                    var strId = ctx.IDENT(i).getText();
                    if (!(tipoId instanceof TiposLa.Registro) ||
                            !((TiposLa.Registro) tipoId).variaveis.containsKey(strId)) {
                        tipoId = TiposLa.INVALIDO;
                        break;
                    }
                    tipoId = ((TiposLa.Registro) tipoId).variaveis.get(strId);
                }
                if (tipoId == TiposLa.INVALIDO) {
                    LaSemanticoUtils.adicionarErroSemantico(
                            ctx.start,
                            String.format(Mensagens.IDENTIFICADOR_NAO_DECLARADO, ctx.getText()));
                }
            }
        } else {
            // TODO: erro - variavel não declarada
            // Talvez seja preciso diferenciar endereços
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.start,
                    String.format(Mensagens.IDENTIFICADOR_NAO_DECLARADO, ctx.getText()));
        }

        return null;
    }

    //Visita o comando chamada
    @Override
    public Void visitCmdChamada(LaSemanticoParser.CmdChamadaContext ctx) {
        ctx.expressao().forEach(this::visitExpressao);
        EntradaTabelaSimbolos etds = escopos.verificarIdent(ctx.IDENT().getText());
        if (etds == null) {
            LaSemanticoUtils.adicionarErroSemantico(
                    ctx.start,
                    String.format(
                            Mensagens.IDENTIFICADOR_NAO_DECLARADO,
                            ctx.start.getText()));
        } else {
            List<Tipos> params = new ArrayList<>();
            if (etds.tipo instanceof TiposLa.Funcao) {
                params = ((TiposLa.Funcao) etds.tipo).parametros;
            } else if (etds.tipo instanceof TiposLa.Procedimento) {
                params = ((TiposLa.Procedimento) etds.tipo).parametros;
            }
        }
        return null;
    }

    //Visita parcela unária
    @Override
    public Void visitParcela_unario(LaSemanticoParser.Parcela_unarioContext ctx) {
        if (ctx.IDENT() != null) {
            LaSemanticoUtils.verificarTipo(escopos, ctx);
        } else if (ctx.expressaoParam != null) {
            visitExpressao(ctx.expressaoParam);
        } else if (ctx.identificador() != null) {
            visitIdentificador(ctx.identificador());
        }
        return null;
    }
}
