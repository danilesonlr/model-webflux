package br.com.webflux.model_webflux.infrastructure.config;

import br.com.webflux.model_webflux.application.PessoaUseCase;
import br.com.webflux.model_webflux.application.gateway.PessoaRepositoryGateway;
import br.com.webflux.model_webflux.application.impl.PessoaUseCaseImpl;
import br.com.webflux.model_webflux.infrastructure.gateway.PessoaRepositoryGatewayImpl;
import br.com.webflux.model_webflux.infrastructure.mapper.PessoaMapper;
import br.com.webflux.model_webflux.infrastructure.repository.PessoaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class BeanConfig {

  @Bean
  public PessoaUseCase useCase(PessoaRepositoryGateway useCase) {
    return new PessoaUseCaseImpl(useCase);
  }

}
