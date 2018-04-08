# SOAPExercicio
   
 A aplicação desenvolvida  consiste em um  sistema de reserva de livros.    
 
 Temos basicamenre três cruds javaweb  usando o servidor payara  e o postgres.   
Como domínio da aplicação temos apenas três entidade: Autor,Livro e Reserva.

 É uma simples aplicação para o uso didático,não foram abordados   
 conceitos de segurança e validação de dados por exemplo. A aplicação foi criada seguindo o "caminho feliz" , ou seja , quando estiver  implantada no servidor espera-se que o cliente preencha de forma correta os dados dos formulários.   
 Focamos apenas em criar um container para aplicação java e um container para o banco de dados da aplicação junto ao docker, podemos observar o comportamento do protocolo SOAP  usado com o objetivo de integrar sistemas. 
 

 
Concebido para resolução de atividade final da disciplina de POS   
Curso **Análise e Desenvolvimento de Sistemas**   
IFPB Campus Cajazerias   
Professor da disciplina Ricardo Job   



## Prerequisitos
* Java instalado
* Maven instalado
* Docker instalado

Uma vez com os itens acima em sua maquina acredito que já saiba usar o docker, caso não saiba veja aqui como [fazer](https://github.com/WellingtonLins/CRUD-Docker).


## Implantando a aplicação

Primeiro faça o download dessa aplicação e abra  o terminal do docker e navegue ate a pasta onde esta o codigo da aplicação.  Lá estão o arquivo `docker-compose.yml`, no terminal docker digite :    
```
docker-compose up -d
```
Com esse comando o docker vai criar as imagens e o containers da aplicação.
Em seguida abra o browser no endereço:    


Como nós estamos usando o Windows(home) temos que abrir nesse endereço:


[http://192.168.99.100:8080/SoapExercicio/](http://192.168.99.100:8080/SoapExercicio/)

Caso use um ambiente Linux adapte as configurções da aplicação (no arquivo `glassfish-resources.xml`) para rodar no localhost:

[http://localhost:8080/SoapExercicio/](http://localhost:8080/SoapExercicio/)

 

  Caso tudo dê certo você verá uma mensagem **HelloWorld!**.

## Consumindo o serviço SOAP

Uma vez que aplicação estiver implantada você pode acessar as seguintes urls para obter os serviços e assim usar qualquer linguagem como cliente para consumir os serviços.  

#### Urls em um ambiente Linux:   


* wsimport -Xnocompile -keep -verbose  http://localhost:8080/ReservaSOAPService/ReservaSOAP?WSDL

* wsimport -Xnocompile -keep -verbose http://localhost:8080/SoapExercicio/LivroSOAPService?WSDL

* wsimport -Xnocompile -keep -verbose http://localhost:8080/SoapExercicio/AutorSOAPService?WSDL

#### Urls em mbiente Windows(home)

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/ReservaSOAPService/ReservaSOAP?WSDL

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/SoapExercicio/LivroSOAPService?WSDL

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/SoapExercicio/AutorSOAPService?WSDL




## Documentação Docker
[Docker referências](https://docs.docker.com/reference/ )

## Construído com 

* [Java](http://www.dropwizard.io/1.0.2/docs/) - Lingugem de programação
* [Postgres](https://www.postgresql.org) - Banco de dados 
* [Maven](https://maven.apache.org/) - Gerenciador de dependencias
* [Payara](www.payara.org/) - Servidor Web usado para a implantação do projeto
* [Docker](https://www.docker.com) - Gerenciador de containers onde podemos usar o container do Tomcat... 
* [NetBeans](https://netbeans.org/downloads/) - Usado para escrever o codigo fonte do projeto
* [SOAP](https://pt.wikipedia.org/wiki/SOAP) - Protocolo usado para fazer a comunicação entre as aplicações cliente e servidor.

## Controle de versão

Nós usamos o [Git](https://git-scm.com/) . 




## Agradecimentos

* Ao professor Ricardo Job 


## Here I can listen you call my name: 

wellingtonlins2013@gmail.com

#### Tell me your problems and doubts...