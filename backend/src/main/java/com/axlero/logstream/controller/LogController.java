package com.axlero.logstream.controller;

import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.SearchResponse;
import com.axlero.logstream.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }
    @Operation(
            summary = "Search Logs",
            description = "Search logs using keyword, filters, sorting and pagination"
    )
    @ApiResponses({
            @ApiResponse(responseCode="200", description= "Logs retrieved successfully"),
            @ApiResponse(responseCode="400",description ="Invalid search request")
    })
    @PostMapping("/search")
    public SearchResponse searchLogs(@Valid @RequestBody SearchRequest request){
        return logService.searchLogs(request);
    }
}
