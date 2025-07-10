package br.com.webflux.model_webflux.interfaces.mapper;

import br.com.webflux.model_webflux.domain.entities.Endereco;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.interfaces.dto.PessoaDTO;

public class PessoaDTOMapper {

  public static Pessoa pessoaToEntity(PessoaDTO pessoaDTO) {
    Endereco endereco = new Endereco(null, pessoaDTO.cep(), null, null, null);
    return new Pessoa(null, pessoaDTO.nome(), pessoaDTO.cpf(),
        pessoaDTO.email(), pessoaDTO.idade(),
        endereco);
  }

}
