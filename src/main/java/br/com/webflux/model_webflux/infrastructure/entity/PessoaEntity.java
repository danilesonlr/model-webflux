package br.com.webflux.model_webflux.infrastructure.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

//@Table("Pessoa")
@Document(collection = "pessoa")
public record PessoaEntity(String nome, String cpf, String email, Integer idade, String cep) {
}
