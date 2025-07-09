package br.com.webflux.model_webflux.application.impl;

import br.com.webflux.model_webflux.application.EnderecoUseCase;
import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.application.port.PessoaRepositoryPort;
import br.com.webflux.model_webflux.domain.entities.Endereco;
import br.com.webflux.model_webflux.domain.entities.Pessoa;


public class PessoaUseCaseImpl implements PessoaUseCase {

  private PessoaRepositoryPort pessoaRepositoryGateway;


  public PessoaUseCaseImpl(PessoaRepositoryPort pessoaRepositoryGateway) {
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
