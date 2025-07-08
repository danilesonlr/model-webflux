package br.com.webflux.model_webflux.domain.entities;

import java.util.UUID;

public record Pessoa(Long id, String nome, String cpf, String email, Integer idade) {
  public Pessoa {
    if (nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
    }

    if (idade < 18) {
      throw new IllegalArgumentException("Pessoa deve ser maior de idade (18+)");
    }
  }
}
