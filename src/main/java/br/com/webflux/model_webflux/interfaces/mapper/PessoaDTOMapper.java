package br.com.webflux.model_webflux.interfaces.mapper;

import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.interfaces.dto.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaDTOMapper {

  PessoaDTOMapper INSTANCE = Mappers.getMapper(PessoaDTOMapper.class);
  Pessoa pessoaToEntity(PessoaDTO pessoaDTO);
  PessoaDTO pessoaEntityToDTO(Pessoa pessoaEntity);
}
