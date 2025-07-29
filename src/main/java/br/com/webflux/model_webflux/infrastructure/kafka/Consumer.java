package br.com.webflux.model_webflux.infrastructure.kafka;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverRecord;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

  /*  KafkaReceiver<String, String>. Ao contrário do KafkaTemplate do Spring Kafka clássico, no Spring WebFlux
com Kafka reativo (usando reactor-kafka), você precisa configurar o KafkaSender manualmente.*/
  private final KafkaReceiver<String, String> kafkaReceiver;

 // Exemplo metodo void
 @PostConstruct
  public void consume() {
    kafkaReceiver
        .receive()
        .doOnNext(record -> {
          log.info("Consumido do Kafka: {}", record.value());

          // Confirmação manual do offset (importante)
          record.receiverOffset().acknowledge();
        })
        .subscribe();
  }

/* @PostConstruct
  public Flux<String> consume() {
    return kafkaReceiver.receive()
        .doOnNext(record -> {
          log.info("Consumido do Kafka: {}", record.value());
          record.receiverOffset().acknowledge(); // Confirma o offset
        })
        .map(ReceiverRecord::value)
        .doOnError(e -> log.error("Erro ao consumir mensagem", e))
        .onErrorResume(e -> Flux.empty()); // Continua em caso de erro
  }*/
}
