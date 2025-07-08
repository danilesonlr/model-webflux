package br.com.webflux.model_webflux.domain.exception;

public class BusinessException extends RuntimeException {


  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String code, String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }
}
