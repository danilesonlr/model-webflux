package br.com.webflux.model_webflux.infrastructure.adapter;

import br.com.webflux.model_webflux.application.port.PessoaRepositoryPort;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.mapper.EnderecoMapper;
import br.com.webflux.model_webflux.infrastructure.mapper.PessoaMapper;
import br.com.webflux.model_webflux.infrastructure.repository.EnderecoRepository;
import br.com.webflux.model_webflux.infrastructure.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaRepositoryAdapter implements PessoaRepositoryPort {
  private final PessoaRepository pessoaRepository;
  private final EnderecoRepository enderecoRepository;


  @Override
  public Mono<Pessoa> save(Pessoa pessoa) {
   return pessoaRepository.save(PessoaMapper.entitieToPessoaEntity(pessoa))
       .thenReturn(pessoa)
       .doOnSuccess(entity -> log.info("Pessoa salvo com sucesso!"));
       //.doOnError(error -> log.error("Erro ao salvar pessoa: {}", error.getMessage(), error));
       //.onErrorMap(error -> new RuntimeException(error.getMessage()));
  }

  @Override
  public Flux<Pessoa> findAll() {
    return pessoaRepository.findAll()
        .flatMap(pessoa ->
            enderecoRepository.findByCep(pessoa.cep())
                .map(endereco -> {
                  Pessoa pessoaComEndereco = new Pessoa(
                      pessoa.id(),
                      pessoa.nome(),
                      pessoa.cpf(),
                      pessoa.email(),
                      pessoa.idade(),
                      EnderecoMapper.entityToEndereco(endereco)
                  );
                  return pessoaComEndereco;
                })
        )
        .doOnComplete(() -> log.info("Pessoa lista com sucesso!"));
  }
}
