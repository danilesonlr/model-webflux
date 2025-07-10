package br.com.webflux.model_webflux.domain.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Endereco(String id, String cep, String logradouro, String localidade, String uf) {
}
