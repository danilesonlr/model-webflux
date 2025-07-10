package br.com.webflux.model_webflux.application.usecases.impl;

import br.com.webflux.model_webflux.application.port.PessoaServicePort;
import br.com.webflux.model_webflux.application.usecases.PessoaUseCase;
import br.com.webflux.model_webflux.domain.entities.Pessoa;

public class PessoaUseCaseImpl implements PessoaUseCase {

  private PessoaServicePort pessoaRepositoryGateway;

  public PessoaUseCaseImpl(PessoaServicePort pessoaRepositoryGateway) {
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

  @Override
  public void delete(Pessoa pessoa) {

  }

  @Override
  public Object update(Pessoa pessoa) {
    return null;
  }
}
