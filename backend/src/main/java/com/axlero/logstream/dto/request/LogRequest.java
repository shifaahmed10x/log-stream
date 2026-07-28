package com.axlero.logstream.dto.request;

import com.axlero.logstream.enums.LogLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogRequest {

    @NotBlank(message = "Application name is required")
    private String applicationName;

    @NotBlank(message = "Service name is required")
    private String serviceName;

    @NotBlank(message = "Host name is required")
    private String hostName;

    @NotNull(message = "Log level is required")
    private LogLevel logLevel;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull(message = "Timestamp is required")
    private LocalDateTime timestamp;

    private String loggerName;

    private String threadName;
}