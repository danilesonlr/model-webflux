package br.com.webflux.model_webflux.infrastructure.gateway;

import br.com.webflux.model_webflux.application.gateway.PessoaRepositoryGateway;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.domain.exception.BusinessException;
import br.com.webflux.model_webflux.infrastructure.mapper.PessoaMapper;
import br.com.webflux.model_webflux.infrastructure.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaRepositoryGatewayImpl implements PessoaRepositoryGateway {
  private final PessoaRepository pessoaRepository;

  @Override
  public Object save(Pessoa pessoa) {
   return pessoaRepository.save(PessoaMapper.INSTANCE.entitieToPessoaEntity(pessoa))
       .map(PessoaMapper.INSTANCE::entityToEntitie)
       .doOnSuccess(entity -> log.info("Pessoa salvo com sucesso!"));
       //.doOnError(error -> log.error("Erro ao salvar pessoa: {}", error.getMessage(), error));
       //.onErrorMap(error -> new RuntimeException(error.getMessage()));
  }

  @Override
  public Object findAll() {
    return pessoaRepository.findAll()
        .map(PessoaMapper.INSTANCE::entityToEntitie)
        .doOnComplete(() -> log.info("Pessoa lista com sucesso!"));
        //.doOnError(error -> log.error("Erro ao salvar pessoa: {}", error.getMessage(), error));
        //.onErrorMap(error -> new RuntimeException(error.getMessage()));
  }
}
