# fipe-api


Esse é um projeto de API da da tabela fipe com os modelos e marcas dos carros. 



### 📜️ Objetivos
- [x] UtilizEI os verbos HTTP d
- [x] Aplicar os princípios da idempotência

### 🚀 Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- [Java 11](https://go.java/?intcmp=gojava-banner-java-com)
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=linux)
- [Mysql Workbench](https://dev.mysql.com/downloads/workbench/) ou [Spring Tool Suite](hhttps://spring.io/tools)
- [Docker](https://www.docker.com/get-started)
- Uma conta [AWS](https://aws.amazon.com/pt/)
- [Postman](https://www.postman.com/downloads/)


### 💻️ Começando o projeto:
▶️ Clone do repositório do projeto usando o comando abaixo no seu terminal.

   ```shell
   > git clone https://github.com/KarenSant/fipe-api.git
   ```
 
▶️ Na pasta src/resources/db/migration você encontrará um arquivo, esse arquivo possibilita criar a primeira versão da sua base de dados

▶️ Realizei a criação da base de dados e configuração no application.yml a conexão e configuração do JPA e FlyWay. 
  
- Adicionar um base path para a aplicação. 
  
### 1 - Criei um CRUD para as marcas:
- Adicionar um endpoint para cadastrar as marcas de carros 
  - **Exemplo de contrato para o endpoint :**
    
    ``` json
    {
    "key"*: "fiat-6",
    "name"*: "FIAT",
    "country": "ITALIA"
    }
    ```
- Possibilitar que as marcas sejam consultadas por: nome

- Criar um endpoint de manipulaçao para as marcas.

### 2 -CRUD para os carros:
- Criei um endpoint para criaçao de carros.

**Exemplo de informações que serão recebidas:**
``` json
{
"key"*: "palio-4826",
"brand_id*": 6,
"name"*: "Palio 1.0 Celebr. ECONOMY F.Flex 8V 4p",
"category"*: "SPORT",
"amount"*: 100000
}
```
⚠️ Utilizei o valor em centavos.

- [x] É Possível que os carros sejam consultados por marca, nome e categoria.

### Realizei a integração com uma API real da tabela FIPE utilizando WebClient.

- **Api utilizada** : http://deividfortuna.github.io/fipe/

### 5 - Sempre que realizar uma busca, seja de carro ou marca, na base e esse resultado não for encontrado, deve realizar a chamada da API Fipe e receber os resultados e salvar na base de dados local

- Como essa API não reconhece trechos de palavras e não fIZ tratativa para completar os textos, por isso deve-se passar parâmetros completos.
  
**Exemplo:**
  - Passar o nome correto do carro. Passar FIAT UNO e não FIT UN
  - Passar o nome correto da marca. Passar Mercedes e não Mercds
  - etc...
  
