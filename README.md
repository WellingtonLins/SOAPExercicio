# SOAPExercicio
   
 A aplicação desenvolvida  consiste em um  sistema de reserva de livros.    
 
 Temos basicamenre três cruds javaweb  usando o servidor payara  e o postgres.   
Como domínio da aplicação temos apenas três entidades: Autor,Livro e Reserva. Usamos o padrão de projeto MVC e DAO.

 É uma simples aplicação para o uso didático,não foram abordados   
 conceitos de segurança e validação de dados por exemplo. A aplicação foi criada seguindo o "caminho feliz" , ou seja , quando estiver  implantada no servidor espera-se que o cliente preencha de forma correta os dados dos formulários.   
 Focamos apenas em criar um container para aplicação java e um container para o banco de dados da aplicação junto ao docker, podemos observar o comportamento do protocolo SOAP  usado com o objetivo de integrar sistemas. 
 

 
Concebido para resolução de atividade final da disciplina de POS   
Curso **Análise e Desenvolvimento de Sistemas**   
IFPB Campus Cajazerias   
Professor da disciplina Ricardo Job   



## Pré-requisitos
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


* http://localhost:8080/ReservaSOAPService/ReservaSOAP?WSDL

* http://localhost:8080/SoapExercicio/LivroSOAPService?WSDL

* http://localhost:8080/SoapExercicio/AutorSOAPService?WSDL

#### Urls em mbiente Windows(home)

* http://192.168.99.100:8080/ReservaSOAPService/ReservaSOAP?WSDL

* http://192.168.99.100:8080/SoapExercicio/LivroSOAPService?WSDL

* http://192.168.99.100:8080/SoapExercicio/AutorSOAPService?WSDL

Com esses endereços você vai ter acesso a Web Services Description Language (**WSDL**) que é justamente uma linguagem baseada em XML utilizada para descrever Web Services.

Funciona como um contrato de serviço entre cliente e servidor. Trata-se de um documento escrito em XML que além de descrever o serviço, especifica como acessá-lo e quais os métodos disponíveis para o comsumo em qualquer linguagem de programação que suporte o protocolo `SOAP`.

## Consumindo com java 


Crie um projeto maven qualquer em java , pode ser web ou desktop.    
Por exemplo vamos criar um projeto java SE chamado **SoapExerciccioCliente** em seguida abra o terminal dentro do projeto e navegue ate a pasta **SoapExerciccioCliente\src\main\java**, uma vez no diretorio digite os seguintes comandos: 

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/ReservaSOAPService/ReservaSOAP?WSDL

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/SoapExercicio/LivroSOAPService?WSDL

wsimport -Xnocompile -keep -verbose  http://192.168.99.100:8080/SoapExercicio/AutorSOAPService?WSDL

Caso esteja usando o linux mude a url para `http://localhost:8080` ao inves de   `http://192.168.99.100:8080`.

Com o comando acima o java vai gerar com base no WSDL  toda a infraestrutura para que seja possivel consumir o serviço oferecido pela aplicação `SOAPExercicio` que disponibiliza a reserva de Livros.

Abaixo segue a lista completa de classes gerados: 


```
Autor.java
AutorSOAP.java
AutorSOAPService.java
BuscarAutorPorId.java
BuscarAutorPorIdResponse.java
BuscarLivroPorId.java
BuscarLivroPorIdResponse.java
BuscarLivroPorTitulo.java
BuscarLivroPorTituloResponse.java
BuscarReservaPorId.java
BuscarReservaPorIdResponse.java
BuscarReservaPorUsuario.java
BuscarReservaPorUsuarioResponse.java
BuscarTodasReservas.java
BuscarTodasReservasResponse.java
BuscarTodosAutores.java
BuscarTodosAutoresResponse.java
BuscarTodosLivros.java
BuscarTodosLivrosResponse.java
DeletarLivro.java
DestroyJustOneReservaFromUser.java
DestroyReserva.java
DestroyReservaByID.java
DestruirAutor.java
EditarAutor.java
EditarLivro.java
EditarReserva1.java
EditarReservaByUserAndTitle.java
Livro.java
LivroSOAP.java
LivroSOAPService.java
nomes.txt
ObjectFactory.java
package-info.java
Reserva.java
ReservaSOAP.java
ReservaSOAPService.java
SalvarAutor.java
SalvarLivro.java
SalvarReserva.java

```

###  Criando um Autor na Aplicação 

Com as classes geradas podemos comsumir os serviços, vamos então criar um Autor e enviar ao web service:

Crie uma Classe chamada ClienteAutor e faça como abaixo:
```
public class ClienteAutor {

    public static void main(String[] args) {
        AutorSOAPService service = new AutorSOAPService();
        AutorSOAP autorSOAPPort = service.getAutorSOAPPort();
        Autor autor = new Autor();
        autor.setAbreviacao("JA");
        autor.setEmail("alencar@gmail.com");
        autor.setNome("Jose de Alencar");

        autorSOAPPort.salvarAutor(autor);

    }
}
```
Com esse codigo acima criamos um autor, e quando rodamos o metodo principal dessa classe ele enviou esse autor para a aplicação e ele foi persistido na base de dados.


###  Criando um Livro 


Crie uma Classe chamada ClienteLivro e nela crie um  metodo main e deixe o codigo igual ao seguinte:
```
public class ClienteLivro {
   LivroSOAPService service = new LivroSOAPService();
   LivroSOAP livroSOAPPort = service.getLivroSOAPPort();

        AutorSOAPService autorSOAPService = new AutorSOAPService();
        AutorSOAP autorSOAPPort = autorSOAPService.getAutorSOAPPort();
        
       //criando o primeiro livro
        Livro livro = new Livro();
        livro.setDescricao("Java SOAP");
        livro.setEdicao("3");
        livro.setDisponivel(Boolean.TRUE);
        livro.setTitulo("SOAP");
        
        //Buscando pelo autor cadastrado anteriormente.
        Autor autor = autorSOAPPort.buscarAutorPorId(1l);

        livro.getAutores().add(autor);
        
        livroSOAPPort.salvarLivro(livro);
    }
}
```
Com esse codigo acima criamos um livro que possui apenas um autor, ambos foram persistidos na base de dados do serviço remoto.


###  Criando a Reserva de um  Livro 


Crie uma Classe chamada ClienteReserva:

```
public class ClienteReserva {
       ReservaSOAPService reservaSOAPService = new ReservaSOAPService();
       ReservaSOAP reservaSOAPPort = reservaSOAPService.getReservaSOAPPort();
      
        Reserva reserva = new Reserva();
        reserva.setUsuario("Joe Ramone");
        reserva.setDataReserva(LocalDate.now().toString());
        reservaSOAPPort.salvarReserva(reserva, "SOAP");
    
    }
}
```
Com esse codigo acima criamos uma reserva  para o livro SOAP, que foi  persistida na base de dados do serviço remoto.
Uma vez criada a reserva outros usuarios não podem  reservar o mesmo livro ate que a reserva anterior seja destruida.


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


#### Tell me your problems and doubts...