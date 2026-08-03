package com.axlero.logstream.controller;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.dto.response.SearchResponse;
import com.axlero.logstream.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@Tag(
        name = "Log Management",
        description = "APIs for managing application logs"
)
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @Operation(
            summary = "Create a new log",
            description = "Stores a new log entry in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Log created successfully"
    )
    @PostMapping
    public ResponseEntity<LogResponse> saveLog(@Valid @RequestBody LogRequest logRequest) {
        LogResponse response = logService.saveLog(logRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Get all logs",
            description = "Retrieves all log entries from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Logs retrieved successfully"
    )
    @GetMapping
    public ResponseEntity<List<LogResponse>> getAllLogs() {
        List<LogResponse> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    @Operation(
            summary = "Get log by ID",
            description = "Retrieves a log entry using its unique ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Log found successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Log not found"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<LogResponse> getLogById(@PathVariable Long id) {
        LogResponse response = logService.getLogById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Update log",
            description = "Updates an existing log entry"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Log updated successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Log not found"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<LogResponse> updateLog(
            @PathVariable Long id,
            @Valid @RequestBody LogRequest request) {

        LogResponse response = logService.updateLog(id, request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Delete log",
            description = "Deletes a log entry by its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Log deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Log not found"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        logService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Search Logs",
            description = "Search logs using keyword, filters, sorting and pagination"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Logs retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid search request"
            )
    })
    @PostMapping("/search")
    public ResponseEntity<SearchResponse> searchLogs(
            @Valid @RequestBody SearchRequest request) {

        SearchResponse response = logService.searchLogs(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Search logs by message",
            description = "Performs Apache Lucene full-text search on log messages"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Matching logs retrieved successfully"
    )
    @GetMapping("/search/message")
    public ResponseEntity<List<LogResponse>> searchMessage(
            @RequestParam String keyword) {

        return ResponseEntity.ok(logService.searchMessage(keyword));
    }
}