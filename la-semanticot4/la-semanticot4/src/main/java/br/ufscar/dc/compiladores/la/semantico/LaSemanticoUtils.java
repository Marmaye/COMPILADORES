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
import org.antlr.v4.runtime.Token;

/**
 *
 * @author maye
 */

//Classe utilizada para fazer as verificações de tipo
public class LaSemanticoUtils {
    
    public static List<String> errosSemanticos = new ArrayList<>();

    //Método para adicionar erro semantico
    public static void adicionarErroSemantico(Token token, String mensagem){
        int linha = token.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    //Verificar tipo básico
    public static Tipos verificarTipo(LaSemanticoParser.Tipo_basicoContext contexto){
        Tipos tipo;
        String stringTipo = contexto.getText();
        switch(stringTipo){
            case "inteiro":
                tipo = TiposLa.INTEIRO;
                break;
            case "real":
                tipo = TiposLa.REAL;
                break;
            case "logico":
                tipo = TiposLa.LOGICO;
                break;
            default: //literal
                tipo = TiposLa.LITERAL;
                break;
        }
        
        return tipo;
    }
    
    //Verificar tipo do valor constante
    public static Tipos verificarTipo(LaSemanticoParser.Valor_constanteContext contexto){
        Tipos tipo;
        
        if(contexto.CADEIA() != null){
            tipo = TiposLa.LITERAL;
        }
        else if(contexto.NUM_INT() != null){
            tipo = TiposLa.INTEIRO;
        }
        else if(contexto.NUM_REAL() != null){
            tipo = TiposLa.REAL;
        }
        else {
            tipo = TiposLa.LOGICO;
        }
        
        return tipo;
    }
    
    //Verificar tipo
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.TipoContext contexto){
        Tipos tipo;
        if (contexto.start.getText().equals("registro")){
            tipo = verificarTipo(escopos, contexto.registro());
        }
        else{
            tipo = verificarTipo(escopos, contexto.tipo_estendido());
        }
        
        return tipo;
    }
    
    //Verificar tipo estendido
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Tipo_estendidoContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.tipo_basico_ident());
        if(contexto.start.getText().equals("^")){ //TODO: verificar
            tipo = new TiposLa.Ponteiro(tipo);
        }
        return tipo;
    }
    
    //Verificar tipo basico do identificador
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Tipo_basico_identContext contexto){
        Tipos tipo;
        if(contexto.tipo_basico() != null){
            tipo = verificarTipo(contexto.tipo_basico());
        }
        
        else{
            EntradaTabelaSimbolos entradats = escopos.verificarIdent(contexto.IDENT().getText());
            if(entradats == null){
                tipo = TiposLa.INVALIDO;
            }
            else{
                tipo = entradats.tipo;
            }
        }
        
        return tipo;
    }
    
    //Verificar tipo do registro
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.RegistroContext contexto){
        Map<String, Tipos> valores = new HashMap<>();
        boolean errado = false;
        for(var variavel : contexto.variavel()){
            Tipos tipoVariavel = verificarTipo(escopos, variavel.tipo());
            for (var ident : variavel.identificador()){
                String strIdent = ident.getText();
                if(valores.containsKey(strIdent)){
                    errado = true;
                }
                else{
                    valores.put(strIdent, tipoVariavel);
                }
            }
        }
        
        if(errado == true){
            return TiposLa.INVALIDO;
        }
        else{
            return new TiposLa.Registro(valores);
        }
    }
    
    //Verificar tipo do identificador
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.IdentificadorContext contexto){
        Tipos tipo = TiposLa.INVALIDO;
        EntradaTabelaSimbolos entradats = escopos.verificarIdent(contexto.ident1.getText());
        
        if(entradats != null){
            tipo = entradats.tipo;
            
            for (var ident : contexto.idents){
                if(tipo instanceof TiposLa.Registro){
                    tipo = ((TiposLa.Registro) tipo).variaveis.get(ident.getText());
                    if (tipo == null){
                        tipo = TiposLa.INVALIDO;
                    }
                }
                else{
                    tipo = TiposLa.INVALIDO;
                }
            }
            
            if(contexto.dimensao() != null){
                for (var expressao : contexto.dimensao().exp_aritmetica()){
                    Tipos tipoIndice = verificarTipo(escopos, expressao);
                    if(tipoIndice != TiposLa.INTEIRO){
                        tipo = TiposLa.INVALIDO;
                    }
                    else if (tipo instanceof TiposLa.Arranjo) {
                        tipo = ((TiposLa.Arranjo) tipo).tipo;
                    }
                }
            }
        }
        
        return tipo;
    }
    
    //Verificar tipo na expressão
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.ExpressaoContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.termoLog1);
        
        if (tipo == TiposLa.LOGICO){
            for (var termo : contexto.termosLog){
                Tipos tipoTermo = verificarTipo(escopos, termo);
                if(tipoTermo != TiposLa.LOGICO){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
            }
        }
        else if (!contexto.termosLog.isEmpty()){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    //Verificar tipo no termo lógico    
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Termo_logicoContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.fatorLog1);
        
        if(tipo == TiposLa.LOGICO){
            for (var fator : contexto.fatoresLog){
                Tipos tipoFator = verificarTipo(escopos, fator);
                if(tipoFator != TiposLa.LOGICO){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
            }
        }
        else if (!contexto.fatoresLog.isEmpty()){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    //Verificar tipo no fator lógico
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Fator_logicoContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.parcela_logica());
        
        if(contexto.start.getText().equals("nao") && tipo != TiposLa.LOGICO){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Parcela_logicaContext contexto){
        Tipos tipo;
        if(contexto.exp_relacional() != null){
            tipo = verificarTipo(escopos, contexto.exp_relacional());
        }
        else{
            tipo = TiposLa.LOGICO;
        }
        
        return tipo;
    }
    
    //Verificar tipo na expressão relacional
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Exp_relacionalContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.expArit1);
        
        if(contexto.expArit2 != null){
            Tipos tipoExp2 = verificarTipo(escopos, contexto.expArit2);
            if(tipo == TiposLa.REAL && (tipoExp2 == TiposLa.REAL || tipoExp2 == TiposLa.INTEIRO)){
                tipo = TiposLa.LOGICO;
            }
            else if(tipo == TiposLa.INTEIRO && (tipoExp2 == TiposLa.REAL || tipoExp2 == TiposLa.INTEIRO)){
                tipo = TiposLa.LOGICO;
            }
            else if(tipo == TiposLa.LITERAL && tipo == tipoExp2){
                tipo = TiposLa.LOGICO;
            }
            else if(tipo instanceof TiposLa.Ponteiro || tipo == TiposLa.LOGICO){
                String operador = contexto.op_relacional().getText();
                if(tipo == tipoExp2 && (operador.equals("=") || operador.equals("<>"))){
                    tipo = TiposLa.LOGICO;
                }
                else{
                    tipo = TiposLa.INVALIDO;
                }
            }
            else{
                tipo = TiposLa.INVALIDO;
            }
        }
        
        return tipo;
    }
    
    //Verificar tipo na expressao aritmetica
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Exp_aritmeticaContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.termo1);
        if(tipo == TiposLa.LITERAL){
            for (int i = 0; i < contexto.termos.size(); i++){
                String op = contexto.operadores.get(i).getText();
                Tipos tipoTermo = verificarTipo(escopos, contexto.termos.get(i));
                if(!op.equals("+") || tipo != tipoTermo){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
            }
        }
        else if(tipo == TiposLa.INTEIRO || tipo == TiposLa.REAL){
            for(var termo : contexto.termos){
                Tipos tipoTermo = verificarTipo(escopos, termo);
                if(tipo == TiposLa.REAL && tipoTermo == TiposLa.INTEIRO || tipo == TiposLa.INTEIRO && tipoTermo == TiposLa.REAL){
                    tipo = TiposLa.REAL;
                }
                else if(tipo != tipoTermo){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
            }
        }
        else if(!contexto.termos.isEmpty()){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    //Verificar tipo no termo
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.TermoContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.fator1);
        if(tipo == TiposLa.INTEIRO || tipo == TiposLa.REAL){
            for (var fator : contexto.fatores){
                Tipos tipoFator = verificarTipo(escopos, fator);
                if(tipoFator != TiposLa.INTEIRO && tipoFator != TiposLa.REAL){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
                else if(tipoFator == TiposLa.REAL){
                    tipo = TiposLa.REAL;
                }
            }
        }
        
        else if(!contexto.fatores.isEmpty()){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    //Verificar tipo no fator
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.FatorContext contexto){
        Tipos tipo = verificarTipo(escopos, contexto.parcela1);
        if(tipo == TiposLa.INTEIRO){
            for(var parcela : contexto.parcelas){
                Tipos tipoParcela = verificarTipo(escopos, parcela);
                if (tipoParcela != TiposLa.INTEIRO){
                    tipo = TiposLa.INVALIDO;
                    break;
                }
            }
        }
        
        else if(!contexto.parcelas.isEmpty()){
            tipo = TiposLa.INVALIDO;
        }
        
        return tipo;
    }
    
    //Verificar tipo na parcela
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.ParcelaContext contexto){
        Tipos tipo;
        
        if(contexto.parcela_unario() != null){
            tipo = verificarTipo(escopos, contexto.parcela_unario());
            if (contexto.opUnar != null && (tipo != TiposLa.INTEIRO && tipo != TiposLa.REAL)){
                tipo = TiposLa.INVALIDO;
            }
        }
        else{
            tipo = verificarTipo(escopos, contexto.parcela_nao_unario());
        }
        
        return tipo;
    }
    
    //Verificar tipo na parcela unária
    public static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Parcela_unarioContext contexto){
        Tipos tipo = TiposLa.INVALIDO;
        
        if(contexto.identificador() != null){
            tipo = verificarTipo(escopos, contexto.identificador());
            if (contexto.OP_PONTEIRO() != null){
                if(tipo instanceof TiposLa.Ponteiro){
                    tipo = ((TiposLa.Ponteiro) tipo).tipo;
                }
                else{
                    tipo = TiposLa.INVALIDO;
                }
            }
        }
        else if(contexto.IDENT() != null){
            EntradaTabelaSimbolos entradats = escopos.verificarIdent(contexto.IDENT().getText());
            if(entradats != null && entradats.tipo instanceof TiposLa.Funcao){
                tipo = entradats.tipo;
                if(contexto.expressoes.size() == ((TiposLa.Funcao) tipo).parametros.size()){
                    for(int i = 0; i < contexto.expressoes.size(); i++){
                        Tipos tipoExp = verificarTipo(escopos, contexto.expressao(i));
                        if(tipoExp != ((TiposLa.Funcao) tipo).parametros.get(i)){
                            tipo = TiposLa.INVALIDO;
                            break;
                        }
                    }
                }
                else{
                    tipo = TiposLa.INVALIDO;
                }
                
                //Verificar tipo de retorno, incluso no Trabalho 4
                if (tipo != TiposLa.INVALIDO){
                    tipo = ((TiposLa.Funcao) tipo).retorno;
                }
                else {
                    LaSemanticoUtils.adicionarErroSemantico(contexto.IDENT().getSymbol(),
                            String.format(Mensagens.INCOMPATIBILIDADE_CHAMADA,
                                    contexto.IDENT().getText()));
                }
            }
        }
        
        else if(contexto.NUM_INT() != null){
            tipo = TiposLa.INTEIRO;
        }
        else if(contexto.NUM_REAL() != null){
            tipo = TiposLa.REAL;
        }
        else {
            tipo = verificarTipo(escopos, contexto.expressaoParam);
        }
        
        return tipo;
    }
    
    //Verificar tipo na parcela não unária
    private static Tipos verificarTipo(Escopos escopos, LaSemanticoParser.Parcela_nao_unarioContext contexto){
        Tipos tipo;
        if(contexto.CADEIA() != null){
            tipo = TiposLa.LITERAL;
        }
        else{
            tipo = verificarTipo(escopos, contexto.identificador());
            if(tipo != TiposLa.INVALIDO){
                tipo = TiposLa.ENDERECO;
            }
        }
        
        return tipo;
    }
    
}
