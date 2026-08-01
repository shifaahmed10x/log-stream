package com.axlero.logstream.dto.response;

import com.axlero.logstream.enums.AlertSeverity;
import com.axlero.logstream.enums.AlertStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertResponse {

    private Long id;

    private Long logId;

    private String applicationName;

    private String message;

    private AlertSeverity severity;

    private AlertStatus status;

    private LocalDateTime createdAt;
}