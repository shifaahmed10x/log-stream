package com.axlero.logstream.mapper;

import com.axlero.logstream.dto.response.AlertResponse;
import com.axlero.logstream.entity.Alert;

public class AlertMapper {

    private AlertMapper() {
    }

    public static AlertResponse toResponse(Alert alert) {

        return AlertResponse.builder()
                .id(alert.getId())
                .logId(alert.getLogId())
                .applicationName(alert.getApplicationName())
                .message(alert.getMessage())
                .severity(alert.getSeverity())
                .status(alert.getStatus())
                .createdAt(alert.getCreatedAt())
                .build();
    }
}