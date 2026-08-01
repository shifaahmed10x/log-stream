package com.axlero.logstream.service;

import com.axlero.logstream.dto.response.AlertResponse;
import com.axlero.logstream.entity.Log;

import java.util.List;

public interface AlertService {

    void processAlert(Log log);

    List<AlertResponse> getAllAlerts();

}