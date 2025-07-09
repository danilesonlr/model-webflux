package br.com.webflux.model_webflux.application.port;

import br.com.webflux.model_webflux.domain.entities.Pessoa;


public interface PessoaRepositoryPort {
  Object save(Pessoa pessoa);
  Object findAll();
}
