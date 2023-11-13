package com.yangyoung.server.dto.lecture.request;

import lombok.Data;

@Data
public class LectureInfoUpdateRequest {
    private String name;
    private String prof;
    private Integer type;
    private Integer condition;
    private Integer time;
    private String book;
}
