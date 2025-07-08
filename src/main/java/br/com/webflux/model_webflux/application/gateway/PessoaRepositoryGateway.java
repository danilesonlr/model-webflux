package br.com.webflux.model_webflux.application.gateway;

import br.com.webflux.model_webflux.domain.entities.Pessoa;


public interface PessoaRepositoryGateway {
  Object save(Pessoa pessoa);
  Object findAll();
}
