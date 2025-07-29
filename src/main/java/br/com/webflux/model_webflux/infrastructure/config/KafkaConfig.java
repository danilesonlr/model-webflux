package br.com.webflux.model_webflux.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

  @Value("${kafka.producer.bootstrap-servers}")
  private String bootstrapServersProducer;

  @Value("${kafka.producer.key-serializer}")
  private String keyDeserializerProducer;

  @Value("${kafka.producer.value-serializer}")
  private String valueDeserializerProducer;

  @Value("${kafka.consumer.bootstrap-servers}")
  private String bootstrapServersConsumer;

  @Value("${kafka.consumer.group-id}")
  private String groupId;

  @Value("${kafka.consumer.auto-offset-reset}")
  private String autoOffsetReset;

  @Value("${kafka.consumer.key-deserializer}")
  private String keyDeserializer;

  @Value("${kafka.consumer.value-deserializer}")
  private String valueDeserializer;

/*  KafkaSender<String, String>. Ao contrário do KafkaTemplate do Spring Kafka clássico, no Spring WebFlux
  com Kafka reativo (usando reactor-kafka), você precisa configurar o KafkaSender manualmente.*/

  @Bean
  public KafkaSender<String, String> kafkaSender() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersProducer);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keyDeserializerProducer);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueDeserializerProducer);

    SenderOptions<String, String> senderOptions = SenderOptions.create(props);
    return KafkaSender.create(senderOptions);
  }

  @Bean
  public ReceiverOptions<String, String> baseReceiverOptions() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConsumer);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);

    return ReceiverOptions.create(props);
  }
}
