package com.axlero.logstream.mapper;

import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.enums.LogLevel;
import org.apache.lucene.document.Document;

import java.time.LocalDateTime;

public class LuceneDocumentMapper {

    private LuceneDocumentMapper() {
    }

    public static LogResponse toResponse(Document document) {

        return LogResponse.builder()
                .id(Long.parseLong(document.get("id")))
                .applicationName(document.get("applicationName"))
                .serviceName(document.get("serviceName"))
                .hostName(document.get("hostName"))
                .logLevel(LogLevel.valueOf(document.get("logLevel")))
                .message(document.get("message"))
                .loggerName(document.get("loggerName"))
                .threadName(document.get("threadName"))
                .timestamp(LocalDateTime.parse(document.get("timestamp")))
                .build();
    }
}