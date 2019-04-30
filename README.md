# Prova

A prova foi desenvolvida em java usando Java 8 e JUnit 4

Criando o projeto

O arquivo "Prova.zip" contem os fontes, após descompactar o arquivo 
é nescessário utilizar uma IDE ex: eclipse e import como "project java" e 
se for presciso adicionar no java build Path JRE system Library e JUnit4.

Criando as pastas para leitura e escrita de arquivos

A prova contempla diretórios do sitema de arquivos Windows.
A próxima melhoria irá contemplar os diretorios de sistema do Linux.
Deve criar as pastas a partir dos diretorios User.home.
Criar a pasta "data" e dentro as pastas "in" e "out".

Como executar

Na package com.prova.main foi criada a classe "RunApplication.java"
É preciso rodar como java application, na IDE eclipse selecione o arquivo e
com o botao direito vai aparecer a opção "run as java application"
O systema irá rodar e nenhuma mensagem irá aparecer no console.
Deve então colocar arquivos ".dat" na pasta in e verifica na pasta out o arquivo gerado.


Classe de Teste

Na package com.prova.ilegra.business foi criada a classe ApplicationBusinessTest.java.
Nesta Classe contem os cenario de teste das regras de negocio implementada.
Deve se rodar com o Junit.
