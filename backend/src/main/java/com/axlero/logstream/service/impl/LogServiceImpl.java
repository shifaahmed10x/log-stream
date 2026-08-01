package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.exception.ResourceNotFoundException;
import com.axlero.logstream.mapper.LogMapper;
import com.axlero.logstream.repository.LogRepository;
import com.axlero.logstream.service.AlertService;
import com.axlero.logstream.service.LogService;
import org.springframework.stereotype.Service;
import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.SearchResponse;
import com.axlero.logstream.specification.LogSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import com.axlero.logstream.service.LuceneIndexService;
import com.axlero.logstream.service.WebSocketService;

import java.util.List;

/*
        Implemented LogService interface
*/
@Service
public class LogServiceImpl implements LogService {
    // here we had use Constructor Injection instead of @Autowired
    private final LogRepository logRepository;
    private final LuceneIndexService luceneIndexService;
    private final AlertService alertService;
    private final WebSocketService webSocketService;

    public LogServiceImpl(
            LogRepository logRepository,
            LuceneIndexService luceneIndexService,
            AlertService alertService,
            WebSocketService webSocketService) {

        this.logRepository = logRepository;
        this.luceneIndexService = luceneIndexService;
        this.alertService = alertService;
        this.webSocketService = webSocketService;
    }


    @Override
    // saving all log here
    public LogResponse saveLog(LogRequest request) {

        Log log = LogMapper.toEntity(request);
        Log savedLog = logRepository.save(log);
        alertService.processAlert(savedLog);
        try {
            luceneIndexService.indexLog(savedLog);
        } catch (Exception e) {
            throw new RuntimeException("Failed to index log in Lucene", e);
        }
        LogResponse response = LogMapper.toResponse(savedLog);

        webSocketService.sendLog(response);

        return response;
    }

    @Override
    public List<LogResponse> getAllLogs() {
        return logRepository.findAll()
                .stream()
                .map(LogMapper::toResponse) // log -> LogMapper.toResponse(log
                .toList();
    }

    @Override
    public LogResponse getLogById(Long id) {

        Log log = logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found with id : " + id));

        return LogMapper.toResponse(log);
    }

    @Override
    public void deleteLog(Long id) {
        Log log = logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found with id : " + id));
        logRepository.deleteById(id);
    }

    @Override
    public LogResponse updateLog(Long id, LogRequest request) {
        Log log = logRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log not found with id : " + id));
        log.setApplicationName(request.getApplicationName());
        log.setServiceName(request.getServiceName());
        log.setHostName(request.getHostName());
        log.setLogLevel(request.getLogLevel());
        log.setMessage(request.getMessage());
        log.setLoggerName(request.getLoggerName());
        log.setThreadName(request.getThreadName());
        log.setTimestamp(request.getTimestamp());

        Log updatedLog = logRepository.save(log);
        return LogMapper.toResponse(updatedLog);

    }

    @Override
    public SearchResponse searchLogs(SearchRequest request) {

        Specification<Log> specification = LogSpecification.search(request);

        Sort sort = "desc".equalsIgnoreCase(request.getSortDirection())
                ? Sort.by(request.getSortBy()).descending()
                : Sort.by(request.getSortBy()).ascending();

        Pageable pageable = PageRequest.of(
                request.getPage(),
                request.getPageSize(),
                sort
        );

        Page<Log> logs = logRepository.findAll(specification, pageable);

        List<LogResponse> logResponses = logs.getContent()
                .stream()
                .map(LogMapper::toResponse)
                .toList();

        return SearchResponse.builder()
                .logs(logResponses)
                .totalRecords(logs.getTotalElements())
                .totalPages(logs.getTotalPages())
                .currentPage(logs.getNumber())
                .pageSize(logs.getSize())
                .first(logs.isFirst())
                .last(logs.isLast())
                .build();
    }
    @Override
    public List<LogResponse> searchMessage(String keyword) {

        try {
            return luceneIndexService.searchByMessage(keyword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
