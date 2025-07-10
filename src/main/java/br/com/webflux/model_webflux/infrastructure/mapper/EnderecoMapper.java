package br.com.webflux.model_webflux.infrastructure.mapper;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import br.com.webflux.model_webflux.infrastructure.entity.EnderecoEntity;

public class EnderecoMapper {

  public static Endereco entityToEndereco(EnderecoEntity entity) {
    return new Endereco( entity.id(),
        entity.cep(), entity.logradouro(),
        entity.localidade(), entity.uf());
  }

  public static EnderecoEntity enderecoToEntity(Endereco endereco) {
    return new EnderecoEntity( endereco.id(),
        endereco.cep(), endereco.logradouro(),
        endereco.localidade(), endereco.uf());
  }
}
