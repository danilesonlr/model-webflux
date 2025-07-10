package br.com.webflux.model_webflux.application.usecases.impl;

import br.com.webflux.model_webflux.application.port.PessoaServicePort;
import br.com.webflux.model_webflux.application.usecases.PessoaUseCase;
import br.com.webflux.model_webflux.domain.entities.Pessoa;

public class PessoaUseCaseImpl implements PessoaUseCase {

  private PessoaServicePort pessoaServicePort;

  public PessoaUseCaseImpl(PessoaServicePort pessoaRepositoryGateway) {
    this.pessoaServicePort = pessoaRepositoryGateway;
  }

  @Override
  public Object save(Pessoa pessoa) {
    return pessoaServicePort.save(pessoa);
  }

  @Override
  public Object findAll() {
    return pessoaServicePort.findAll();
  }

  @Override
  public Object delete(String id) {
    return pessoaServicePort.delete(id);
  }

  @Override
  public Object update(String id, Pessoa pessoa) {
    return pessoaServicePort.update(id, pessoa);
  }

  @Override
  public Object findById(String id) {
    return pessoaServicePort.findById(id);
  }


}
