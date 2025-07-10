package br.com.webflux.model_webflux.infrastructure.integration;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ViaCepClientClient {
  private final WebClient webClient;

  public ViaCepClientClient(WebClient.Builder builder) {
    this.webClient = builder.baseUrl("https://viacep.com.br/ws").build();
  }

  public Mono<Endereco> buscarEndereco(String cep) {
    return webClient
        .get()
        .uri("/{cep}/json", cep)
        .retrieve()
        .bodyToMono(Endereco.class);
  }
}
