package com.yangyoung.server.lecture.dto.request;

import lombok.Data;

@Data
public class LectureInfoUpdateRequest {
    private String name;
    private String prof;
    private Integer type;
    private Integer lectureCondition;
    private Integer time;
    private String book;
}
