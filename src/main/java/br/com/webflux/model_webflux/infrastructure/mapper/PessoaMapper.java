package br.com.webflux.model_webflux.infrastructure.mapper;

import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.entity.PessoaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

  PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

  Pessoa entityToEntitie(PessoaEntity pessoaEntity);
  PessoaEntity entitieToPessoaEntity(Pessoa pessoa);
}
