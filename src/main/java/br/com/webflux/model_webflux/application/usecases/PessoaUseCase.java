package br.com.webflux.model_webflux.application.usecases;

import br.com.webflux.model_webflux.application.port.PessoaServicePort;
import br.com.webflux.model_webflux.domain.entities.Pessoa;

public class PessoaUseCase {

  private PessoaServicePort pessoaServicePort;

  public PessoaUseCase(PessoaServicePort pessoaRepositoryGateway) {
    this.pessoaServicePort = pessoaRepositoryGateway;
  }


  public Object save(Pessoa pessoa) {
    return pessoaServicePort.save(pessoa);
  }

  public Object findAll() {
    return pessoaServicePort.findAll();
  }

  public Object delete(String id) {
    return pessoaServicePort.delete(id);
  }

  public Object update(String id, Pessoa pessoa) {
    return pessoaServicePort.update(id, pessoa);
  }

  public Object findById(String id) {
    return pessoaServicePort.findById(id);
  }
}
