package br.com.webflux.model_webflux.application.port;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import reactor.core.publisher.Mono;

public interface ViaCepPort {
  Mono<Endereco> buscarEndereco(String cep);
}
