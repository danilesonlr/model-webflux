package br.com.webflux.model_webflux.infrastructure.mapper;

import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.entity.PessoaEntity;

public class PessoaMapper {

  public static Pessoa entityToEntitie(PessoaEntity pessoaEntity) {
    return new Pessoa(pessoaEntity.id(), pessoaEntity.nome(), pessoaEntity.cpf(),
        pessoaEntity.email(), pessoaEntity.idade(), null);
  }
  public static PessoaEntity entitieToPessoaEntity(Pessoa pessoa){
    return new PessoaEntity(pessoa.id(), pessoa.nome(), pessoa.cpf(),
        pessoa.email(), pessoa.idade(),  pessoa.endereco().cep());
  }
}
