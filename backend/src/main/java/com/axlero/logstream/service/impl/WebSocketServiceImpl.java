package com.axlero.logstream.service.impl;

import com.axlero.logstream.dto.response.LogResponse;
import com.axlero.logstream.service.WebSocketService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendLog(LogResponse response) {

        messagingTemplate.convertAndSend(
                "/topic/logs",
                response
        );
    }
}