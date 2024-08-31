Leia, por favor.

- Swagger : http://localhost:8080/swagger-ui/index.html
- SQL Schema : Database.sql, dentro de resources.
- ER Diagram : ER-Diagram.png, dentro de resources
- Dentro de Dabase.sql, execute todos os create, tables antes de subir a API
- TODO: Seria bom instalar o flyway para gerenciar o versionamento do BD
- Agora temos um docker compose, se quiser utiliza-lo use o comando : docker-compose up
- Dentro de resources temos os JSON files que podem ser utilizados dentro do postman para testes.

Consulte o link do Swagger para verficar a docuemntação da API.

Execute esses comandos nessa sequencia dentro da pasta findmyjob.v1:

- Comandos para geração das imagens: 
    - docker build -t postgres -f ./src/main/resources/database/Dockerfile .
    - docker build -t findmyjob -f ./src/main/resources/app/Dockerfile .

- Comando para subir o projeto
    - docker compose up