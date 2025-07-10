# model-webflux
Modelo de programação reativa com webflux, utilizando arquitetura clean arch


Docker compose para criar o banco de dados via docker



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

# Acessar no mongoDB compass 

mongodb://admin:senha123@localhost:27017/?authSource=admin

# Acessar aplicação

http://localhost:8080/webjars/swagger-ui/index.html#/


