package com.axlero.logstream.controller;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogResponse>  saveLog (@RequestBody LogRequest logRequest){
        LogResponse response = logService.saveLog(logRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
