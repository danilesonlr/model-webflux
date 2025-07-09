package br.com.webflux.model_webflux.domain.entities;

import br.com.webflux.model_webflux.domain.exception.BusinessException;

import java.util.UUID;

public record Pessoa(Long id, String nome, String cpf, String email, Integer idade) {
  public Pessoa {
    if (nome == null || nome.isBlank()) {
      throw new BusinessException("Nome não pode ser nulo ou vazio");
    }

    if (idade < 18) {
      throw new BusinessException("Pessoa deve ser maior de idade (18+)");
    }
  }
}
