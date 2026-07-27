package com.axlero.logstream.controller;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<LogResponse>> getAllLogs(){
        List<LogResponse> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
   public ResponseEntity<LogResponse> getLogById(@PathVariable Long id){
        LogResponse response = logService.getLogById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id){
        logService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogResponse> updateLog(@PathVariable Long id , @RequestBody LogRequest request){
        LogResponse response = logService.updateLog(id,request);
        return ResponseEntity.ok(response);
    }


}
