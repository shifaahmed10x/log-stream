package com.axlero.logstream.service;

import com.axlero.logstream.dto.response.ApplicationCountResponse;
import com.axlero.logstream.dto.response.DailyLogCountResponse;
import com.axlero.logstream.dto.response.LogLevelCountResponse;

import java.util.List;

public interface AnalyticsService {

    List<LogLevelCountResponse> getLogLevelCounts();

    List<ApplicationCountResponse> getApplicationCounts();

    List<DailyLogCountResponse> getDailyLogCounts();

}