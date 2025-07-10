package br.com.webflux.model_webflux.infrastructure.adapter;

import br.com.webflux.model_webflux.application.port.EnderecoRepositoryPort;
import br.com.webflux.model_webflux.domain.entities.Endereco;
import br.com.webflux.model_webflux.infrastructure.mapper.EnderecoMapper;
import br.com.webflux.model_webflux.infrastructure.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnderecoRepositoryAdapter implements EnderecoRepositoryPort {

  private final EnderecoRepository enderecoRepository;

  @Override
  public Mono<Endereco> save(Endereco endereco) {
    return enderecoRepository.save(EnderecoMapper.enderecoToEntity(endereco))
        .map(EnderecoMapper::entityToEndereco)
        .doOnSuccess(entity -> log.info("Endereco salvo com sucesso!"));
  }

  @Override
  public Mono<Endereco> findByCep(String cep) {
    return enderecoRepository.findByCep(cep)
        .map(EnderecoMapper::entityToEndereco)
        .doOnSuccess(entity -> log.info("Endereco recuperado com sucesso!"));
  }
}
