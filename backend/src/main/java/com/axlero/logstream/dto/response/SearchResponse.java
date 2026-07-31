package com.axlero.logstream.dto.response;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponse {
    private List<LogResponse> logs;
    private Long totalRecords;
    private Integer totalPages;
    private Integer currentPage;
    private Integer pageSize;
    private Boolean first;
    private Boolean last;
}
