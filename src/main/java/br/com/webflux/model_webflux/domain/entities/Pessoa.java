package br.com.webflux.model_webflux.domain.entities;

import br.com.webflux.model_webflux.domain.utils.StringValidation;
import br.com.webflux.model_webflux.domain.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Pessoa(String id, String nome, String cpf, String email, Integer idade, Endereco endereco) {

  public Pessoa {
    validarCampoObrigatorio(nome, "Nome");
    validarCampoObrigatorio(cpf, "CPF");
    validarCampoObrigatorio(email, "E-mail");
    validarEndereco(endereco);
    validarIdade(idade);

    if (!StringValidation.isValidCpf(cpf)) {
      throw new BusinessException("CPF inválido valor: " + cpf);
    }

    if (!StringValidation.isValidEmail(email)) {
      throw new BusinessException("E-mail inválido valor: " + email);
    }

    if (!StringValidation.isValidCep(endereco.cep())) {
      throw new BusinessException("CEP inválido, formato valido 00000-00");
    }

  }

  private void validarCampoObrigatorio(String valor, String campo) {
    if (valor == null || valor.isBlank()) {
      throw new BusinessException(campo + " não pode ser nulo ou vazio");
    }
  }

  private void validarEndereco(Endereco endereco) {
    if (endereco == null || endereco.cep() == null || endereco.cep().isBlank()) {
      throw new BusinessException("CEP não pode ser nulo ou vazio");
    }
  }

  private void validarIdade(Integer idade) {
    if (Optional.ofNullable(idade).orElse(0) < 18) {
      throw new BusinessException("Pessoa deve ser maior de idade (18+)");
    }
  }
}