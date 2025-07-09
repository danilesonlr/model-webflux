package br.com.webflux.model_webflux.interfaces.config;

import br.com.webflux.model_webflux.domain.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public Mono<ResponseEntity<ApiErro>> handleGenericException(Exception ex) {
    log.error("Erro inesperado: ", ex);
    ApiErro apiErro = ApiErro.builder()
        .message("Erro interno do servidor")
        .statusHttp(HttpStatus.INTERNAL_SERVER_ERROR)
        .timestamp(LocalDateTime.now())
        .build();

    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErro));
  }

  @ExceptionHandler(BusinessException.class)
  public Mono<ResponseEntity<ApiErro>> handleBusinessException(BusinessException ex) {
    log.error("Business error: ", ex);
    ApiErro apiErro = ApiErro.builder()
        .message("Falha na aplicação. Motivo: " + ex.getMessage())
        .statusHttp(HttpStatus.BAD_REQUEST)
        .timestamp(LocalDateTime.now())
        .build();

    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErro));
  }
}
