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

    @NotBlank
    private String applicationName;

    @NotBlank
    private String serviceName;

    @NotBlank
    private String hostName;

    @NotNull
    private LogLevel logLevel;

    @NotBlank
    private String message;

    private String loggerName;

    private String threadName;

    @NotNull
    private LocalDateTime timestamp;
}