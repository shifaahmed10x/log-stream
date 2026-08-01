package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.response.AlertResponse;
import com.axlero.logstream.entity.Alert;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.enums.AlertSeverity;
import com.axlero.logstream.enums.AlertStatus;
import com.axlero.logstream.enums.LogLevel;
import com.axlero.logstream.mapper.AlertMapper;
import com.axlero.logstream.repository.AlertRepository;
import com.axlero.logstream.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;


    @Override
    public void processAlert(Log log) {

        if (log.getLogLevel() != LogLevel.ERROR) {
            return;
        }

        Alert alert = Alert.builder()
                .logId(log.getId())
                .applicationName(log.getApplicationName())
                .message(log.getMessage())
                .severity(AlertSeverity.HIGH)
                .status(AlertStatus.OPEN)
                .build();

        alertRepository.save(alert);
    }

    @Override
    public List<AlertResponse> getAllAlerts() {

        return alertRepository.findAll()
                .stream()
                .map(AlertMapper::toResponse)
                .toList();
    }
}