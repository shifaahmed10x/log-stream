package com.axlero.logstream.service;

import com.axlero.logstream.dto.response.LogResponse;

public interface WebSocketService {

    void sendLog(LogResponse response);

}