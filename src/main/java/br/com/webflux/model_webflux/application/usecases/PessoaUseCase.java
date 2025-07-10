package br.com.webflux.model_webflux.application.usecases;

import br.com.webflux.model_webflux.domain.entities.Pessoa;

public interface PessoaUseCase {
  Object save(Pessoa pessoa);
  Object findAll();
  void delete(Pessoa pessoa);
  Object update(Pessoa pessoa);
}
