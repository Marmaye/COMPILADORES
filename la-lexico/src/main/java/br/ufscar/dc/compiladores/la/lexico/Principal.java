package br.ufscar.dc.compiladores.la.lexico;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import br.ufscar.dc.compiladores.la.lexico.LALexer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Principal {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("java -jar <programa> <arquivo-de-entrada> <arquivo-de-saida>");
            return;
        }
        
        // Nome do arquivo de entrada
        String arquivoEntrada = args[0];
        
        // Nome do arquivo de saída
        String arquivoSaida = args[1];
        try (OutputStream os = new FileOutputStream(arquivoSaida)) {
            
            
            CharStream cs = CharStreams.fromFileName(arquivoEntrada);
            LALexer lexer = new LALexer(cs);
            
            Token t;
            String mensagem;
            byte[] buffer;
            
            Vocabulary vocabulary = lexer.getVocabulary();
            
            while ((t = lexer.nextToken()).getType() != LALexer.EOF) {
                String tokenTypeName = LALexer.VOCABULARY.getSymbolicName(t.getType());
                String tokenValue = t.getText();
                System.out.println(tokenValue);
                System.out.println(tokenTypeName);

                if (tokenTypeName.equals("PALAVRA_CHAVE") ||
                        tokenTypeName.equals("DELIMITADOR") ||
                        tokenTypeName.equals("OP1") ||
                        tokenTypeName.equals("OP2") ||
                        tokenTypeName.equals("OP3") ||
                        tokenTypeName.equals("OP_RELACIONAL") ||
                        tokenTypeName.equals("ABREPAR") ||
                        tokenTypeName.equals("FECHAPAR") ||
                        tokenTypeName.equals("OP_ATRIBUICAO") ||
                        tokenTypeName.equals("OP_INTERVALO") ||
                        tokenTypeName.equals("CIRCUNFLEXO") ||
                        tokenTypeName.equals("AND") ||
                        tokenTypeName.equals("ABRECOL") ||
                        tokenTypeName.equals("FECHACOL")
                        
                ) {
                    mensagem = "<'" + tokenValue + "','" + tokenValue + "'>\n";
                    buffer = mensagem.getBytes(StandardCharsets.UTF_8);
                    os.write(buffer);
                } else if (tokenTypeName.equals("DESCONHECIDO")) {
                    // Token inválido
                    int linha = t.getLine();
                    if (tokenValue.startsWith("\"")) {
                        // Cadeia não fechada
                        mensagem = "Linha " + linha + ": cadeia literal nao fechada\n";
                    } else if (tokenValue.startsWith("{")) {
                        // Comentário não fechado
                        mensagem = "Linha " + linha + ": comentario nao fechado\n";
                    } else {
                        // Outros tokens inválidos
                        mensagem = "Linha " + linha + ": " + tokenValue + " - simbolo nao identificado\n";
                    }

                    buffer = mensagem.getBytes(StandardCharsets.UTF_8);
                    os.write(buffer);
                    break;
                } else {
                    // Token correto
                    mensagem = "<'" + tokenValue + "'," + tokenTypeName + ">\n";
                    buffer = mensagem.getBytes(StandardCharsets.UTF_8);
                    os.write(buffer);
                }
            }
        } catch (IOException ex) {
            System.out.println("Falha ao abrir o arquivo.");
        }
    }
}
