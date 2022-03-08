# Backend
 
## Ferramentas/Tecnologias utilizadas
- Java 11;
- Spring Boot v2.6.3
- Maven v4.0.0

## Preparando ambiente

### Passo 1: configuração do banco
>  *Você precisará criar um banco de dados com o nome 'votacao'*

### Passo 2: configurar application.properties
>  *Você precisará verificar se os dados passados no application.properties estão de acordo com a sua máquina*
#### application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/votacao
spring.datasource.username=postgres
spring.datasource.password=postgres
```
Obs: caso algum desses dados: username, password ou port esteja diferente do seu banco, favor corrigir.

## Rodando a aplicação 

Navegue até a raiz do projeto

Execute `cd votacao`

Execute `mvn spring-boot:run`

## Testando com  Postman

Existe um arquivo no diretório **votação** chamado *Votacao.postman_collection.json*, você poderá importá-lo no Postman para facilitar nos testes.

### Para fazer a importação, execute os seguintes passos:
>  *No menu do Postman selecione File > Import > Upload Files*
>  *Ao selecionar o arquivo clique em Import*