# model-webflux
Modelo de programação reativa com webflux, utilizando arquitetura clean arch


Docker compose para criar o banco de dados via docker

# Criar arquivo docker-compose nomer como  mongo-compose.yml

version: '3.8'

services:
  mongo:
    image: mongo
    container_name: meu-mongo
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD: senha123
    volumes:
      - mongo-data:/data/db

volumes:
  mongo-data:

# Executar docker componse
docker-compose -f mongo-compose.yml up

# Rodar de forma interativa
docker exec -it meu-mongo mongosh -u admin -p senha123 --authenticationDatabase admin


# Acessar colletion
use springWebFlux


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


