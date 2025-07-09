package br.com.webflux.model_webflux.application.impl;

import br.com.webflux.model_webflux.application.EnderecoUseCase;
import br.com.webflux.model_webflux.application.port.EnderecoRepositoryPort;
import br.com.webflux.model_webflux.application.port.ViaCepPort;


public class EnderecoUseCaseImpl implements EnderecoUseCase {
  private ViaCepPort viaCepPort;
  private EnderecoRepositoryPort enderecoRepositoryPort;

  public EnderecoUseCaseImpl(ViaCepPort viaCepPort,
                             EnderecoRepositoryPort enderecoRepositoryPort) {
    this.viaCepPort = viaCepPort;
    this.enderecoRepositoryPort = enderecoRepositoryPort;
  }

  @Override
  public Object findByCep(String cep) {
    return enderecoRepositoryPort.findByCep(cep);
  }

  public Object save(String cep) {
    return viaCepPort.buscarEndereco(cep)
        .flatMap(enderecoRepositoryPort::save);
  }

}
