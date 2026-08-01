package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.response.ApplicationCountResponse;
import com.axlero.logstream.dto.response.DailyLogCountResponse;
import com.axlero.logstream.dto.response.LogLevelCountResponse;
import com.axlero.logstream.repository.LogRepository;
import com.axlero.logstream.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final LogRepository logRepository;

    @Override
    public List<LogLevelCountResponse> getLogLevelCounts() {

        return logRepository.countByLogLevel()
                .stream()
                .map(obj -> LogLevelCountResponse.builder()
                        .logLevel(obj[0].toString())
                        .count((Long) obj[1])
                        .build())
                .toList();
    }

    @Override
    public List<ApplicationCountResponse> getApplicationCounts() {

        return logRepository.countByApplicationName()
                .stream()
                .map(obj -> ApplicationCountResponse.builder()
                        .applicationName(obj[0].toString())
                        .count((Long) obj[1])
                        .build())
                .toList();
    }

    @Override
    public List<DailyLogCountResponse> getDailyLogCounts() {

        return logRepository.countLogsPerDay()
                .stream()
                .map(obj -> DailyLogCountResponse.builder()
                        .date((LocalDate) obj[0])
                        .count((Long) obj[1])
                        .build())
                .toList();
    }
}