package br.com.webflux.model_webflux.infrastructure.mapper;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import br.com.webflux.model_webflux.infrastructure.entity.EnderecoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

  EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

  Endereco entityToEndereco(EnderecoEntity entity);
  EnderecoEntity enderecoToEntity(Endereco endereco);
}

