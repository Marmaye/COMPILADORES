/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufscar.dc.compiladores.la.sintatico;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author maye
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        
        if (args.length < 2) {
            System.out.println("Uso: java -jar <programa> <arquivo-de-entrada> <arquivo-de-saida>");
            return;
        }
        
        // Nome do arquivo de entrada
        String arquivoEntrada = args[0];

        // Nome do arquivo de saída
        String arquivoSaida = args[1];
        
        try(PrintWriter pw = new PrintWriter(arquivoSaida)){
            
            CustomErrorListener cel = new CustomErrorListener(pw);
            
            CharStream cs = CharStreams.fromFileName(arquivoEntrada);
            LaSintaticoLexer lexer = new LaSintaticoLexer(cs);
            
            lexer.removeErrorListeners();
            lexer.addErrorListener(cel);
                

//            Token token = null;
//            while ((token=lexer.nextToken()).getType() != Token.EOF){
//                System.out.println("<"+LaSintaticoLexer.VOCABULARY.getDisplayName(token.getType()) + "," + token.getText() + ">");
//            }
//            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LaSintaticoParser parser = new LaSintaticoParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(cel);
            
            parser.programa();
        
        }catch(ParseCancellationException e){
        
        }
    }
}
