package br.com.webflux.model_webflux.infrastructure.kafka.enums;

import lombok.Getter;

@Getter
public enum FilasKafkaEnum {
  PESSOA("fila.pessoa"),
  EMPRESA ("fila.empresa");

  private String value;

  FilasKafkaEnum(String value) {
    this.value = value;
  }
}
