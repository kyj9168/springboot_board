package com.web.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BoardRequest {
    private Integer b_id;
    private String b_writer;
    private String b_title;
    private String b_contents;
    private LocalDateTime b_created_date;
    private LocalDateTime b_update_date;
}
