package br.com.webflux.model_webflux.infrastructure.entity;


import org.springframework.data.mongodb.core.mapping.Document;


//@Table("Pessoa")
@Document(collection = "pessoa")
public record PessoaEntity(String id, String nome, String cpf, String email, Integer idade, String cep) {
}
