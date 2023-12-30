//package org.example.HelloWorld.kafka.producers;
//
//
//import lombok.extern.log4j.Log4j2;
//import org.example.HelloWorld.kafka.enums.EventType;
//import org.example.HelloWorld.kafka.events.EventMetaData;
//import org.example.HelloWorld.kafka.events.FileProcessingStatusEvent;
//import org.example.HelloWorld.kafka.events.FileProcessingStatusEventPayload;
//import org.example.HelloWorld.kafka.events.IEventData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.CompletableFuture;
//
//
///**
// * Author - lakshya.jain <br>
// * Date - 03/05/2023
// */
//
//
//@Log4j2
//@Service
//public class FileProcessingStatusEventProducer {
//
//    @Autowired
//    @Qualifier("fileProcessingStatusEventProducerKafkaTemplate")
//    private KafkaTemplate<String, IEventData> bureauStoreKafkaTemplate;
//
//    @Value(value = "${kafka.topics.fileManagement.fileProcessingStatus.topicName}")
//    private String topicName;
//
//    public void pushEvent(FileProcessingStatusEventPayload payload) {
//        IEventData eventData = FileProcessingStatusEvent.builder()
//                .payload(payload)
//                .metaData(EventMetaData.builder()
//                        .eventType(EventType.AMS_FILE_PROCESSING_STATUS.name())
//                        .version("1.0")
//                        .platform("PAYUFIN")
//                        .source("PAYUFIN")
//                        .build()).build();
//
//        log.info(eventData.getClass());
//
//        CompletableFuture<SendResult<String, IEventData>> future = bureauStoreKafkaTemplate.send(topicName, eventData);
//        future.whenComplete((result, ex) -> {
//            if (ex == null) {
//                System.out.println("Sent message=[" + eventData +
//                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
//            } else {
//                System.out.println("Unable to send message=[" +
//                        eventData + "] due to : " + ex.getMessage());
//            }
//        });
//    }
//
//}
