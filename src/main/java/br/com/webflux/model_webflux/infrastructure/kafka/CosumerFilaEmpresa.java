package br.com.webflux.model_webflux.infrastructure.kafka;

import br.com.webflux.model_webflux.infrastructure.kafka.enums.FilasKafkaEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CosumerFilaEmpresa extends KafkaConsumirTemplate {

  @Override
  protected void processar() {
    createReceiver(FilasKafkaEnum.EMPRESA.getValue())
        .receive()
        .doOnNext(record -> {
          log.info("Consumindo fila_empresa Mensagem: {}", record.value());
          record.receiverOffset().acknowledge();
        })
        .subscribe();
  }
}
