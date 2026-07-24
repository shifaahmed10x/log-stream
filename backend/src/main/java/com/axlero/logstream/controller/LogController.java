package com.axlero.logstream.controller;

import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.SearchResponse;
import com.axlero.logstream.service.LogService;
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
    @PostMapping("/search")
    public SearchResponse searchLogs(@RequestBody SearchRequest request){
        return logService.searchLogs(request);
    }
}
