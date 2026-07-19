package com.axlero.logstream.dto.response;

import com.axlero.logstream.enums.LogLevel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogResponse {

    private Long id;

    private String applicationName;

    private String serviceName;

    private String hostName;

    private LogLevel logLevel;

    private String message;

    private String loggerName;

    private String threadName;

    private LocalDateTime timestamp;

    private LocalDateTime createdAt;
}