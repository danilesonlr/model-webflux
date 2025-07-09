package br.com.webflux.model_webflux.interfaces.config;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiErro {
  private String message;
  private HttpStatus statusHttp;
  private LocalDateTime timestamp;

}
