package br.com.webflux.model_webflux.infrastructure.repository;

import br.com.webflux.model_webflux.infrastructure.entity.EnderecoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EnderecoRepository extends ReactiveCrudRepository<EnderecoEntity, String> {
  Mono<EnderecoEntity> findByCep(String cep);
}
