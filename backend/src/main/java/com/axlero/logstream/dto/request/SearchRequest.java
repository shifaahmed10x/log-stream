package com.axlero.logstream.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchRequest {
    private String keyword;
    private String applicationName;
    private String serviceName;
    private String hostName;
    private String logLevel;
    private String loggerName;
    private String threadName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Min(value = 0, message = "page number cannot be negative")
    private Integer page = 0;
    @Min(value = 1, message = "minimum page size 1")
    @Max(value = 10, message = "maxmimum page size 10")
    private Integer pageSize = 10;
    private String sortBy = "timestamp";
    private String sortDirection = "desc";

}