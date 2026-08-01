package com.axlero.logstream.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogLevelCountResponse {

    private String logLevel;

    private Long count;
}