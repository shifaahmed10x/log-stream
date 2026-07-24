package com.axlero.logstream.service;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.dto.response.SearchResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LogService {
    LogResponse saveLog(LogRequest request);
    List<LogResponse> getAllLogs();
    LogResponse getLogById(Long id);
    void deleteLog(Long id);
    SearchResponse searchLogs(SearchRequest request);

}
