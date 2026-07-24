package com.axlero.logstream.service.impl;
import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.dto.response.SearchResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.repository.LogRepository;
import com.axlero.logstream.service.LogService;
import com.axlero.logstream.specification.LogSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    private final LogRepository logRepository;
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository= logRepository;
    }
    @Override
    public LogResponse saveLog(LogRequest request){
        return null;
    }
    @Override
    public List<LogResponse> getAllLogs(){
        return List.of();
    }
    @Override
    public LogResponse getLogById(Long id){
        return null;
    }
    @Override
    public void deleteLog(Long id){

    }
    @Override
    public SearchResponse searchLogs(SearchRequest request){
        Specification<Log> specification = LogSpecification.search(request);

        Sort sort = request.getSortDirection().equalsIgnoreCase("desc")
                ? Sort.by(request.getSortBy()).descending()
                : Sort.by(request.getSortBy()).ascending();

        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), sort);
        Page<Log> logs = logRepository.findAll(specification, pageable);
        List<LogResponse> logResponses = logs.getContent().stream()
                .map(log -> LogResponse.builder()
                        .id(log.getId())
                        .applicationName(log.getApplicationName())
                        .serviceName(log.getServiceName())
                        .hostName(log.getHostName())
                        .logLevel(log.getLogLevel())
                        .message(log.getMessage())
                        .loggerName(log.getLoggerName())
                        .threadName(log.getThreadName())
                        .timestamp(log.getTimestamp())
                        .createdAt(log.getCreatedAt())
                        .build()
                )
                .toList();
        return  SearchResponse.builder()
                .logs(logResponses)
                .totalRecords(logs.getTotalElements())
                .totalPages(logs.getTotalPages())
                .currentPage(logs.getNumber())
                .pageSize(logs.getSize())
                .first(logs.isFirst())
                .last(logs.isLast())
                .build();
    }

}