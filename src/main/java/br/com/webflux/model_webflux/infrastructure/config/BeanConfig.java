package br.com.webflux.model_webflux.infrastructure.config;

import br.com.webflux.model_webflux.application.EnderecoUseCase;
import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.application.impl.EnderecoUseCaseImpl;
import br.com.webflux.model_webflux.application.port.EnderecoRepositoryPort;
import br.com.webflux.model_webflux.application.port.PessoaRepositoryPort;
import br.com.webflux.model_webflux.application.impl.PessoaUseCaseImpl;
import br.com.webflux.model_webflux.application.port.ViaCepPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public EnderecoUseCase getEnderecoUseCase(ViaCepPort viaCepPort,
                                            EnderecoRepositoryPort enderecoRepositoryPort) {
    return new EnderecoUseCaseImpl(viaCepPort, enderecoRepositoryPort);
  }

  @Bean
  public PessoaUseCase getPessoaUseCase(PessoaRepositoryPort pessoaRepositoryPort,
                                        EnderecoUseCase enderecoUseCase) {
    return new PessoaUseCaseImpl(pessoaRepositoryPort, enderecoUseCase);
  }

}
