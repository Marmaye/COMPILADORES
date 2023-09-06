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
- para limpar e resetar:                                                                                                          
mvn clean package
- para criar o pacote e instalar o que precisa:   
mvn install

Como executar:
- para usar o corretor:   
java -jar compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar target/la-gerador-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc temp casos-de-teste "790139" "t5"
# Trabalho 6
-gymPlanner (nome da pasta)

  # GymPlanner.
  Uma linguagem desenvolvida para criar planner semanal de treinamento de academia.

  # Compilar.
  1.mvn clean package.
  compilar e empacotar o projeto.

  2. mvn install
  instala todas as dependência necessárias e gera o executável.


  # Executar.
  java -jar target/gymplanner-1.0-SNAPSHOT-jar-with-dependencies.jar C:\caminho\para\arquivo.txt saida.html

  # Exemplo.
  **Entrada:**

  ![image](https://github.com/Marmaye/TRABALHO6_COMPILADORES/assets/137102335/2a38626c-713c-4941-a91b-804c4ab11b54)

  **Saída:**
  ![image](https://github.com/Marmaye/TRABALHO6_COMPILADORES/assets/137102335/9bfe50fe-75cb-4b93-af42-26d17b579222)

