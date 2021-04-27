package com.web.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BoardResponse {
    private Integer id;
    private String writer;
    private String title;
    private String contents;
    private LocalDateTime created_date;
    private LocalDateTime update_date;
}
