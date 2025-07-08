package br.com.webflux.model_webflux.infrastructure.gateway;

import br.com.webflux.model_webflux.application.gateway.PessoaRepositoryGateway;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.mapper.PessoaMapper;
import br.com.webflux.model_webflux.infrastructure.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PessoaRepositoryGatewayImpl implements PessoaRepositoryGateway {
  private final PessoaRepository pessoaRepository;

  @Override
  public Object save(Pessoa pessoa) {
   return pessoaRepository.save(PessoaMapper.INSTANCE.entitieToPessoaEntity(pessoa))
       .map(PessoaMapper.INSTANCE::entityToEntitie);
  }

  @Override
  public Object findAll() {
    return pessoaRepository.findAll().map(PessoaMapper.INSTANCE::entityToEntitie);
  }
}
