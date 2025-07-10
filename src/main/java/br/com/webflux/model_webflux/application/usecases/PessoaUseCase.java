package br.com.webflux.model_webflux.application.usecases;

import br.com.webflux.model_webflux.domain.entities.Pessoa;

public interface PessoaUseCase {
  Object save(Pessoa pessoa);
  Object findAll();
  Object delete(String id);
  Object update(String id, Pessoa pessoa);
  Object findById(String id);
}
