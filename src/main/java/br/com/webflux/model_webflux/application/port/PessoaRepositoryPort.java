package br.com.webflux.model_webflux.application.port;

import br.com.webflux.model_webflux.domain.entities.Pessoa;
import reactor.core.publisher.Mono;


public interface PessoaRepositoryPort {
  Mono<Pessoa> save(Pessoa pessoa);
  Object findAll();
}
