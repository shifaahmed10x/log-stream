package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.exception.ResourceNotFoundException;
import com.axlero.logstream.mapper.LogMapper;
import com.axlero.logstream.repository.LogRepository;
import com.axlero.logstream.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;
/*
        Implemented LogService interface
*/
@Service
public class LogServiceImpl implements LogService {
     // here we had use Constructor Injection instead of @Autowired
    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository){
        this.logRepository=logRepository;
    }


    @Override
    // saving all log here
    public LogResponse saveLog(LogRequest request) {

        Log log = LogMapper.toEntity(request);
        Log savedLog = logRepository.save(log);
        return LogMapper.toResponse(savedLog);
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
               .orElseThrow(()-> new ResourceNotFoundException("Log not found with id : "+ id));

       return  LogMapper.toResponse(log);
    }

    @Override
    public void deleteLog(Long id) {
     Log log = logRepository.findById(id)
             .orElseThrow(()-> new ResourceNotFoundException("Log not found with id : "+id));
     logRepository.deleteById(id);
    }

    @Override
    public LogResponse updateLog(Long id, LogRequest request) {
        Log log = logRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Log not found with id : "+id));
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
}
