package com.axlero.logstream.mapper;

import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.dto.request.LogRequest;

/**
 * Utility class for converting between Log entity and DTOs.
 */

public final class LogMapper { // made final as this is a utility class , nobody should extend it

    private LogMapper() {
       // Prevent instantiation
    }
       public static Log toEntity(LogRequest request){
        // Converts LogRequest DTO to Log entity
           return Log.builder()
                    .applicationName(request.getApplicationName())
                    .serviceName(request.getServiceName())
                    .hostName(request.getHostName())
                    .logLevel(request.getLogLevel())
                    .message(request.getMessage())
                    .loggerName(request.getLoggerName())
                    .threadName(request.getThreadName())
                    .timestamp(request.getTimestamp())
                    .build();
       }
       public  static LogResponse toResponse(Log log){
           // Converts Log entity to LogResponse DTO
           return LogResponse.builder()
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
                   .build();
       }
    }
