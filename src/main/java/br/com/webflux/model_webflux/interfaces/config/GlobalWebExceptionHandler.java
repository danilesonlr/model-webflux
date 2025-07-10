package br.com.webflux.model_webflux.interfaces.config;

import br.com.webflux.model_webflux.domain.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Component
@Order(-2)
public class GlobalWebExceptionHandler extends AbstractErrorWebExceptionHandler {

  public GlobalWebExceptionHandler(ErrorAttributes errorAttributes,
                                   ApplicationContext applicationContext,
                                   ObjectMapper objectMapper) {
    super(errorAttributes, new WebProperties.Resources(), applicationContext);
    this.setMessageWriters(ServerCodecConfigurer.create().getWriters());
    this.setMessageReaders(ServerCodecConfigurer.create().getReaders());
  }

  @Override
  protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
    return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
  }

  private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
    Throwable error = getError(request);

    HttpStatus status;
    String message;

    if (error instanceof BusinessException) {
      status = HttpStatus.BAD_REQUEST;
      message = error.getMessage();
    } else {
      status = HttpStatus.INTERNAL_SERVER_ERROR;
      message = "Erro interno do servidor";
    }

    ApiErro apiErro = ApiErro.builder()
        .timestamp(LocalDateTime.now())
        .statusHttp(status)
        .message(message)
        .build();

    return ServerResponse
        .status(status)
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(apiErro));
  }
}