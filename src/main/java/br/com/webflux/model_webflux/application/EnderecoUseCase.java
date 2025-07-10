package br.com.webflux.model_webflux.application;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import reactor.core.publisher.Mono;

public interface EnderecoUseCase {
  Mono<Endereco> findByCep(String cep);
  Object save(String cep);
  Mono<Endereco> save(Endereco endereco);
  Mono<Endereco> buscarEndereco(String cep);

}
