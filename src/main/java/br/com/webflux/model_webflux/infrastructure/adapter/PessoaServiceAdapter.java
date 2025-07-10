package br.com.webflux.model_webflux.infrastructure.adapter;

import br.com.webflux.model_webflux.application.port.PessoaServicePort;
import br.com.webflux.model_webflux.domain.entities.Pessoa;
import br.com.webflux.model_webflux.infrastructure.integration.ViaCepClientClient;
import br.com.webflux.model_webflux.infrastructure.entity.PessoaEntity;
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
public class PessoaServiceAdapter implements PessoaServicePort {
  private final PessoaRepository pessoaRepository;
  private final EnderecoRepository enderecoRepository;
  private final ViaCepClientClient viaCepClientAdapter;


  @Override
  public Mono<Pessoa> save(Pessoa pessoa) {
    return enderecoRepository.findByCep(pessoa.endereco().cep())
        .switchIfEmpty(
            viaCepClientAdapter.buscarEndereco(pessoa.endereco().cep())
                .flatMap( endereco -> enderecoRepository.save(EnderecoMapper.enderecoToEntity(endereco)))
        )
        .flatMap(endereco -> {
          PessoaEntity pessoaEntity =
              new PessoaEntity(null, pessoa.cpf(), pessoa.nome(), pessoa.email(), pessoa.idade(),
                  pessoa.endereco().cep());
          return pessoaRepository.save(pessoaEntity);
        })
        .map(PessoaMapper::entityToEntitie)
        .doOnSuccess(entity -> log.info("Pessoa salvo com sucesso!"));
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

  @Override
  public void delete(Pessoa pessoa) {

  }

  @Override
  public Object update(Pessoa pessoa) {
    return null;
  }
}
