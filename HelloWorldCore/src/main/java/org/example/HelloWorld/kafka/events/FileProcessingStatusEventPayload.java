package org.example.HelloWorld.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

/**
 * Author - lakshya.jain <br>
 * Date - 03/05/2023
 */

@Builder
@Data
@AllArgsConstructor
public class FileProcessingStatusEventPayload {

    private UUID fileId;
    private String status;

}
