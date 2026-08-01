package com.axlero.logstream.controller;

import com.axlero.logstream.dto.response.ApplicationCountResponse;
import com.axlero.logstream.dto.response.DailyLogCountResponse;
import com.axlero.logstream.dto.response.LogLevelCountResponse;
import com.axlero.logstream.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/log-level-count")
    public ResponseEntity<List<LogLevelCountResponse>> getLogLevelCounts() {

        return ResponseEntity.ok(
                analyticsService.getLogLevelCounts()
        );
    }

    @GetMapping("/application-count")
    public ResponseEntity<List<ApplicationCountResponse>> getApplicationCounts() {

        return ResponseEntity.ok(
                analyticsService.getApplicationCounts()
        );
    }

    @GetMapping("/logs-per-day")
    public ResponseEntity<List<DailyLogCountResponse>> getDailyLogCounts() {

        return ResponseEntity.ok(
                analyticsService.getDailyLogCounts()
        );
    }
}