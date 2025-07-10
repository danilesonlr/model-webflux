package br.com.webflux.model_webflux.application.impl;

import br.com.webflux.model_webflux.application.EnderecoUseCase;
import br.com.webflux.model_webflux.application.port.EnderecoRepositoryPort;
import br.com.webflux.model_webflux.application.port.ViaCepPort;
import br.com.webflux.model_webflux.domain.entities.Endereco;
import reactor.core.publisher.Mono;


public class EnderecoUseCaseImpl implements EnderecoUseCase {
  private ViaCepPort viaCepPort;
  private EnderecoRepositoryPort enderecoRepositoryPort;

  public EnderecoUseCaseImpl(ViaCepPort viaCepPort,
                             EnderecoRepositoryPort enderecoRepositoryPort) {
    this.viaCepPort = viaCepPort;
    this.enderecoRepositoryPort = enderecoRepositoryPort;
  }

  @Override
  public Mono<Endereco>  findByCep(String cep) {
    return enderecoRepositoryPort.findByCep(cep);
  }

  @Override
  public Object save(String cep) {
    return viaCepPort.buscarEndereco(cep)
        .flatMap(enderecoRepositoryPort::save);
  }

  @Override
  public Mono<Endereco> save(Endereco endereco) {
    return enderecoRepositoryPort.save(endereco);
  }

  @Override
  public Mono<Endereco> buscarEndereco(String cep) {
    return viaCepPort.buscarEndereco(cep);
  }

}
