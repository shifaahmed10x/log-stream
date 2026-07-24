package com.axlero.logstream.dto.request;

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
    private Integer page = 0;
    private Integer pageSize = 10;
    private String sortBy = "timestamp";
    private String sortDirection = "desc";
}