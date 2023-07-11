# Trabalho 1
-La-Lexico (nome da pasta)

objetivo: implementar um analizador lexico da linguagem LA(Linguagem Algoritmica), desenvolvida pelo professor jander.


Como compilar:  
passo a passo:
- para criar o arquivo jar:   
mvn install 
- para um arquivo:  
java -jar target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada.txt saida.txt

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp ./casos-de-teste "790139" "t1"

# Trabalho 2 

La-sintatico(nome da pasta)

objetivo: implementar um analizador sintatico.

Como compilar:  
passo a passo:
- para criar o arquivo jar:   
mvn install 
- para um arquivo:  
java -jar target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada.txt saida.txt

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-lexico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp ./casos-de-teste "790139" "t2"
