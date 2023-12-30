package org.example.HelloWorld.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Author - lakshya.jain <br>
 * Date - 03/05/2023
 */

@Builder
@Data
@AllArgsConstructor
public class FileProcessingStatusEvent implements IEventData {

    private EventMetaData metaData;
    private FileProcessingStatusEventPayload payload;
}
