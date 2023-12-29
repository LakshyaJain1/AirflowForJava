package org.example.HelloWorld.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Author - lakshya.jain <br>
 * Date - 26/04/2023
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventMetaData {
    private String eventType;
    private String version;
    private String platform;
    private String source;
    private Timestamp ts;
}
