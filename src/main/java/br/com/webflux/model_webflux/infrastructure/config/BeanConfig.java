package br.com.webflux.model_webflux.infrastructure.config;

import br.com.webflux.model_webflux.application.port.PessoaServicePort;
import br.com.webflux.model_webflux.application.usecases.PessoaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public PessoaUseCase getPessoaUseCase(PessoaServicePort pessoaRepositoryPort) {
    return new PessoaUseCase(pessoaRepositoryPort);
  }

}
