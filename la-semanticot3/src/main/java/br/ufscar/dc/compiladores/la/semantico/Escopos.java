/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import java.util.LinkedList;

/**
 *
 * @author maye
 */

//Classe para tratar os diferentes escopos do programa da linguagem LA
public class Escopos {
    
    static class Escopo{
        TabelaSimbolos tabela;
        //TiposLa.Tipos tipoRetorno;
        
        Escopo(TabelaSimbolos tabela, TiposLa.Tipos tipoRetorno){
            this.tabela = tabela;
           // this.tipoRetorno = tipoRetorno;
        }
    }
    
    //Escopos são armazenados em pilha
    private LinkedList<Escopo> pilhaEscopos = null;
    
    //Método para iniciar a pilha de escopos
    public Escopos(){
        pilhaEscopos = new LinkedList<>();
        init();
    }
    
    //Metodo para iniciar a pilha de escopos
    public void init(){
        pilhaEscopos.clear();
        criarNovoEscopo(null);
    }
    
    //Criar novo escopo na pilha de escopos
    public void criarNovoEscopo(TiposLa.Tipos tipo){
        pilhaEscopos.push(new Escopo(new TabelaSimbolos(), tipo));
    }
    
    //Obter o escopo atual, que está por cima na pilha
    public TabelaSimbolos obterEscopoAtual(){
        Escopo escopo = pilhaEscopos.peek();
        if(escopo == null){
            return null;
        }
        return escopo.tabela;
        //return pilhaEscopos.peek().tabela;
    }
    
    //Obter o escopo global
    public TabelaSimbolos obterEscopoGlobal(){
        return pilhaEscopos.getLast().tabela;
    }
    
    //Sair de um escopo, tirar o escopo da pilha
    public void sairEscopo(){
        pilhaEscopos.pop();
    }
    
    //Obtem o tipo de retorno de um escopo, se ele possui retorno, como numa função, senão retorna vazio 
//   public TiposLa.Tipos obterTipoRetorno(){
//        Escopo escopo = pilhaEscopos.peek();
//        if(escopo == null) {
//            return null;
//        }
//        
//        return escopo.tipoRetorno;
//    }
    
   //Método para recuperar o nome de um identificador da tabela de símbolos
    public EntradaTabelaSimbolos verificarIdent(String identificador){
        EntradaTabelaSimbolos entradats = obterEscopoAtual().recuperar(identificador);
        if(entradats == null){
            entradats = obterEscopoGlobal().recuperar(identificador);
        }
        return entradats;
    }
}

