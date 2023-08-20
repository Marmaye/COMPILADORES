/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufscar.dc.compiladores.la.gerador;

import br.ufscar.dc.compiladores.la.gerador.TiposLa.Tipos;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author maye
 */
public class TabelaSimbolos {
    
    private final Map<String, EntradaTabelaSimbolos> tabela;
    
    //Construtor da tabela de símbolos
    public TabelaSimbolos(){
        this.tabela = new HashMap<>();
    }
    
    //Método para adicionar elemento na tabela
    public void adicionar(String nome, Tipos tipo){
        tabela.put(nome, new EntradaTabelaSimbolos(nome, tipo));
    }
    
    //Método para verificar se já existe um elemento na tabela
    public boolean verificar(String nome){
        return tabela.containsKey(nome);
    }
    
    //Método para recuperar o elemento da tabela
    public EntradaTabelaSimbolos recuperar(String nome){
        return tabela.get(nome);
    }
}
