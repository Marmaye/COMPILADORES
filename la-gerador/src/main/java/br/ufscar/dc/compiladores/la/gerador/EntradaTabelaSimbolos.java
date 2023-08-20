/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.gerador;

import br.ufscar.dc.compiladores.la.gerador.TiposLa.Tipos;

/**
 *
 * @author maye
 */
public class EntradaTabelaSimbolos {
    
    public String nome; //nome do simbolo
    public Tipos tipo; //tipo do simbolo
    
    //Construtor da classe
    public EntradaTabelaSimbolos(String nome, Tipos tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    
}
