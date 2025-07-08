package br.com.webflux.model_webflux.application;

import br.com.webflux.model_webflux.domain.entities.Pessoa;

import java.util.List;

public interface PessoaUseCase {
  Object save(Pessoa pessoa);
  Object findAll();
}
