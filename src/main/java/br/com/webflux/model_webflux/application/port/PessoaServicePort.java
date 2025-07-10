package br.com.webflux.model_webflux.application.port;

import br.com.webflux.model_webflux.domain.entities.Pessoa;


public interface PessoaServicePort {
  Object save(Pessoa pessoa);
  Object findAll();
  void delete(Pessoa pessoa);
  Object update(Pessoa pessoa);
}
