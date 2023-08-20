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

objetivo: implementar um analizador sintatico para a LA (linguagem algoritmica).

Como compilar:  
passo a passo:
- para criar o arquivo jar:   
mvn install 
- para um arquivo:   
java -jar target/la-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada.txt saida.txt

Como executar:

- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp ./casos-de-teste "790139" "t2"

# Trabalho 3 

La-semanticot3(nome da pasta)

objetivo: implementar parte de um analisador semântico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

Como compilar:  
passo a passo:
- para criar o arquivo jar:   
mvn install 
- para um arquivo:  
java -jar target/la-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada.txt saida.txt

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp ./casos-de-teste "790139" "t3"

# Trabalho 4

La-semanticot4(nome da pasta)

objetivo:implementar uma segunda parte de um analisador semântico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

Como compilar:  
passo a passo:
- para criar o arquivo jar:   
mvn install 
- para um arquivo:  
java -jar target/la-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar entrada.txt saida.txt

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-semantico-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc ./temp ./casos-de-teste "790139" "t4"

# Trabalho 5

la-gerador(nome da pasta)

objetivo:implementar um gerador de código para a linguagem LA.

Como compilar:  
passo a passo:
- para limpar e resetar
mvn clean package
- para criar o pacote e instalar o que precisa:   
mvn install

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-gerador-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc temp casos-de-teste "790139" "t5"
