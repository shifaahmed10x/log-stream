package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.repository.LogRepository;
import com.axlero.logstream.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
     // here we had use Constructor Injection insta of @Autowired
    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository){
        this.logRepository=logRepository;
    }


    @Override
    public LogResponse saveLog(LogRequest request) {
        return null;
    }

    @Override
    public List<LogResponse> getAllLogs() {
        return List.of();
    }

    @Override
    public LogResponse getLogById(Long id) {
        return null;
    }

    @Override
    public void deleteLog(Long id) {

    }
}
