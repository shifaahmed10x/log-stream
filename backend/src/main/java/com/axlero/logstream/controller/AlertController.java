package com.axlero.logstream.controller;

import com.axlero.logstream.dto.response.AlertResponse;
import com.axlero.logstream.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @GetMapping
    public ResponseEntity<List<AlertResponse>> getAllAlerts() {

        return ResponseEntity.ok(alertService.getAllAlerts());
    }
}