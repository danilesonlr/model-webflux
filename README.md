# model-webflux

Modelo de programação reativa com webflux, utilizando arquitetura clean arch e banco de dados não relacional mongoDB.
Foi criado um fluxo aparte para produzir e consumir messagem utilizando kafka reativo.


# Documentação spring webflux

https://projectreactor.io/docs/core/release/api/reactor/core/publisher/package-summary.html

# Executar docker componse

docker-compose -f mongo-compose.yaml up -d

# Rodar de forma interativa

docker exec -it meu-mongo mongosh -u admin -p senha123 --authenticationDatabase admin

# Acessar colletion/criar database

use springWebFlux

# Cria a collection endereco

db.createCollection("endereco")

# Cria a collection pessoa

db.createCollection("pessoa")

# Criar usuario

db.createUser({
user: "teste",
pwd: "teste123",
roles: [ { role: "readWrite", db: "springWebFlux" } ]
})

# Acessar no mongoDB compass (opcional ambiente gráfico)

mongodb://admin:senha123@localhost:27017/?authSource=admin

# Acessar aplicação

http://localhost:8080/webjars/swagger-ui/index.html#/

# Teste

Teste de massa de dados na aplicação.
![teste](teste.png)
