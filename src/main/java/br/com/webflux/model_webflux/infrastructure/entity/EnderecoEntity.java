package br.com.webflux.model_webflux.infrastructure.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "endereco")
public record EnderecoEntity(String cep, String logradouro, String localidade, String uf) {
}
