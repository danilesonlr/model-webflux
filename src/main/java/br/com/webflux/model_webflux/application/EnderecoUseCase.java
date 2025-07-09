package br.com.webflux.model_webflux.application;

import br.com.webflux.model_webflux.domain.entities.Endereco;

public interface EnderecoUseCase {
  Object findByCep(String cep);
  Object save(String cep);

}
