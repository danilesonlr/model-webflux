package br.com.webflux.model_webflux.infrastructure.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaConfig {

/*  KafkaSender<String, String>. Ao contrário do KafkaTemplate do Spring Kafka clássico, no Spring WebFlux
  com Kafka reativo (usando reactor-kafka), você precisa configurar o KafkaSender manualmente.*/

  @Bean
  public KafkaSender<String, String> kafkaSender() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    SenderOptions<String, String> senderOptions = SenderOptions.create(props);
    return KafkaSender.create(senderOptions);
  }

  @Bean
  public KafkaReceiver<String, String> kafkaReceiver() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "webflux-group");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // ou "latest"

    ReceiverOptions<String, String> receiverOptions = ReceiverOptions.<String, String>create(props)
        .subscription(List.of("pessoa_teste")); // nome do tópico

    return KafkaReceiver.create(receiverOptions);
  }
}
