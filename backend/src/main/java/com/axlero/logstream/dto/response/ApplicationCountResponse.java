package com.axlero.logstream.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationCountResponse {

    private String applicationName;

    private Long count;
}