/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufscar.dc.compiladores.la.semantico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author maye
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
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
            
            LaSemanticoLexer lexer = new LaSemanticoLexer(cs);           
            lexer.removeErrorListeners();
            lexer.addErrorListener(cel);
            
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            LaSemanticoParser parser = new LaSemanticoParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(cel);
            
            LaSemanticoParser.ProgramaContext arvore = parser.programa();
            LaSemantico lasem = new LaSemantico();
            lasem.visitPrograma(arvore);
            
            if(!LaSemanticoUtils.errosSemanticos.isEmpty()){
                LaSemanticoUtils.errosSemanticos.forEach(pw::println);
                pw.println("Fim da compilacao");
            }        
        }
        catch(ParseCancellationException e){
        
        }
    }
}

