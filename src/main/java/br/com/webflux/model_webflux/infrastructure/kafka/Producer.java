package br.com.webflux.model_webflux.infrastructure.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {

  /*  KafkaSender<String, String>. Ao contrário do KafkaTemplate do Spring Kafka clássico, no Spring WebFlux
  com Kafka reativo (usando reactor-kafka), você precisa configurar o KafkaSender manualmente.*/
  private final KafkaSender<String, String> kafkaSender;

  public Mono<Void> sendMessageReactive(String msg) {
    return kafkaSender.send(
        Mono.just(SenderRecord.create(
            "pessoa_teste", // Tópico
            null, // Partition (null = Kafka decide)
            System.currentTimeMillis(), // Timestamp
            null, // Key (opcional)
            msg, // Value
            null // Headers (opcional)
        ))
    ).then();
  }
}
