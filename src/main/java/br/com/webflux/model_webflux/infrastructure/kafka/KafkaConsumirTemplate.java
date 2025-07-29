package br.com.webflux.model_webflux.infrastructure.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;

import java.util.List;

public abstract class KafkaConsumirTemplate {

  @Autowired
  private ReceiverOptions baseReceiverOptions;

  protected KafkaReceiver<String, String> createReceiver(String topic) {
    return KafkaReceiver.create(
        baseReceiverOptions.subscription(List.of(topic))
    );
  }

  @PostConstruct
  protected void consumir(){
    processar();
  }

  protected abstract void processar();
}
