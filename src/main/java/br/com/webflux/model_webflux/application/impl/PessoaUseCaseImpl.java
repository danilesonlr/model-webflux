package br.com.webflux.model_webflux.application.impl;

import br.com.webflux.model_webflux.application.EnderecoUseCase;
import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.application.port.PessoaRepositoryPort;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import reactor.core.publisher.Mono;

import java.util.Objects;


public class PessoaUseCaseImpl implements PessoaUseCase {

  private PessoaRepositoryPort pessoaRepositoryGateway;
  private EnderecoUseCase enderecoUseCase;


  public PessoaUseCaseImpl(PessoaRepositoryPort pessoaRepositoryGateway,
                           EnderecoUseCase enderecoUseCase) {
    this.pessoaRepositoryGateway = pessoaRepositoryGateway;
    this.enderecoUseCase = enderecoUseCase;
  }

  @Override
  public Object save(Pessoa pessoa) {
    return enderecoUseCase.findByCep(pessoa.endereco().cep())
        .switchIfEmpty(
            enderecoUseCase.buscarEndereco(pessoa.endereco().cep())
                .flatMap( endereco -> enderecoUseCase.save(endereco))
        )
        .flatMap(endereco -> {
          Pessoa pessoaComEnderedo =
              new Pessoa(null, pessoa.cpf(), pessoa.nome(), pessoa.email(), pessoa.idade(), endereco);
          return pessoaRepositoryGateway.save(pessoaComEnderedo);
        });
  }

  @Override
  public Object findAll() {
    return pessoaRepositoryGateway.findAll();
  }


}
