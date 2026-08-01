package com.axlero.logstream.grpc;

import com.axlero.logstream.dto.request.LogRequest;
import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.enums.LogLevel;
import com.axlero.logstream.service.LogService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDateTime;

@GrpcService
public class LogGrpcServer extends LogServiceGrpc.LogServiceImplBase {

    private final LogService logService;

    public LogGrpcServer(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void saveLog(
            GrpcLogRequest request,
            StreamObserver<GrpcLogResponse> responseObserver) {

        LogRequest logRequest = new LogRequest();

        logRequest.setApplicationName(request.getApplicationName());
        logRequest.setServiceName(request.getServiceName());
        logRequest.setHostName(request.getHostName());
        logRequest.setLogLevel(LogLevel.valueOf(request.getLogLevel()));
        logRequest.setMessage(request.getMessage());
        logRequest.setTimestamp(LocalDateTime.parse(request.getTimestamp()));
        logRequest.setLoggerName(request.getLoggerName());
        logRequest.setThreadName(request.getThreadName());

        LogResponse response = logService.saveLog(logRequest);

        GrpcLogResponse grpcResponse =
                GrpcLogResponse.newBuilder()
                        .setId(response.getId())
                        .setMessage("Log Saved Successfully")
                        .build();

        responseObserver.onNext(grpcResponse);
        responseObserver.onCompleted();
    }
}