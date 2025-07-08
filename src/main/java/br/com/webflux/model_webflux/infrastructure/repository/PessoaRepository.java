package br.com.webflux.model_webflux.infrastructure.repository;

import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.entity.PessoaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//public interface PessoaRepository extends ReactiveCrudRepository<PessoaEntity, Long> {
public interface PessoaRepository extends ReactiveMongoRepository<PessoaEntity, String> {
}
