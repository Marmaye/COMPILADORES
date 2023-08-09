/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.semantico;

import java.util.List;
import java.util.Map;

/**
 *
 * @author maye
 */
public class TiposLa {
    
    //Tipos de termos definidos na linguagem LA
    static class Tipos{
        String nome;
        
        Tipos(String nome){
            this.nome = nome;
        }
    }
    
    static final Tipos INTEIRO = new Tipos("inteiro");
    static final Tipos REAL = new Tipos("real");
    static final Tipos LOGICO = new Tipos("logico");
    static final Tipos INVALIDO = new Tipos("invalido");
    static final Tipos LITERAL = new Tipos("literal");
    static final Tipos ENDERECO = new Tipos("endereco");
    
    static class Ponteiro extends Tipos{
        Tipos tipo;
        
        public Ponteiro(Tipos tipo){
            super("ponteiro");
            this.tipo = tipo;
        }
    }
    
    static class Procedimento extends Tipos{
        List<Tipos> parametros;
        
        public Procedimento(List<Tipos> parametros){
            super("procedimento");
            this.parametros = parametros; 
        }
    }
    
    static class Funcao extends Tipos{
        List<Tipos> parametros;
        Tipos retorno;
        
        public Funcao(List<Tipos> parametros, Tipos retorno){
            super("funcao");
            this.parametros = parametros; 
            this.retorno = retorno;
        }
    }
    
    static class Registro extends Tipos{
        Map<String, Tipos> variaveis;
        
        public Registro(Map<String, Tipos> variaveis){
            super("registro");
            this.variaveis = variaveis; 
        }
    }
    
    static class Arranjo extends Tipos {
        Tipos tipo;

        public Arranjo(Tipos tipo) {
            super("arranjo");
            this.tipo = tipo;
        }
    }
}
