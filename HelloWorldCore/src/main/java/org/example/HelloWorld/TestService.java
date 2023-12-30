package org.example.HelloWorld;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.HelloWorld.kafka.events.FileProcessingStatusEventPayload;
//import org.example.HelloWorld.kafka.producers.FileProcessingStatusEventProducer;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

@Log4j2
@Service
@AllArgsConstructor
public class TestService {

    private ConfigRepository configRepository;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

//    private FileProcessingStatusEventProducer producer;

    public void print() {
        log.info("Message from Base");
        String key = generateRandomString(6);
        ConfigVar configVar = ConfigVar.builder().key(key).value(new Date()).build();
        configRepository.save(configVar);
        log.info(configRepository.findById(key));
//        producer.pushEvent(FileProcessingStatusEventPayload.builder().status("Something").fileId(UUID.randomUUID()).build());
    }

    public String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }


}
