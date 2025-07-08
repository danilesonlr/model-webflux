package br.com.webflux.model_webflux.application.impl;

import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.application.gateway.PessoaRepositoryGateway;
import br.com.webflux.model_webflux.domain.entities.Pessoa;


public class PessoaUseCaseImpl implements PessoaUseCase {

  private PessoaRepositoryGateway pessoaRepositoryGateway;

  public PessoaUseCaseImpl(PessoaRepositoryGateway pessoaRepositoryGateway) {
    this.pessoaRepositoryGateway = pessoaRepositoryGateway;
  }

  @Override
  public Object save(Pessoa pessoa) {
    return pessoaRepositoryGateway.save(pessoa);
  }

  @Override
  public Object findAll() {
    return pessoaRepositoryGateway.findAll();
  }
}
