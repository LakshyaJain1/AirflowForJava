//package org.example.HelloWorld.kafka.config.producers;
//
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.example.HelloWorld.kafka.events.IEventData;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Author - lakshya.jain <br>
// * Date - 03/05/2023
// */
//
//@Configuration
//public class FileProcessingStatusEventProducerConfig {
//
//    @Value(value = "${kafka.bootstrapServers.fileManagement}")
//    private String bootstrapServers;
//
//    @Bean(name = "fileProcessingStatusEventProducerFactory")
//    public ProducerFactory<String, IEventData> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        configProps.put(JsonSerializer.TYPE_MAPPINGS, "fileProcessingStatusEvent:org.example.HelloWorld.kafka.events.FileProcessingStatusEvent");
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean(name = "fileProcessingStatusEventProducerKafkaTemplate")
//    public KafkaTemplate<String, IEventData> defaultProducerKafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
