package com.axlero.logstream.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyLogCountResponse {

    private LocalDate date;

    private Long count;
}