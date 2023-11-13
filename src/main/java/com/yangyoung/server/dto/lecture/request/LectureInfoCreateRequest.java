package com.yangyoung.server.dto.lecture.request;

import com.yangyoung.server.entity.lecture.Lecture;

public class LectureInfoCreateRequest {
    private String name;
    private String prof;
    private Integer type;
    private Integer condition;
    private Integer time;
    private String book;

    public Lecture toEntity() {
        return Lecture.builder()
                .name(name)
                .prof(prof)
                .time(type)
                .condition(condition)
                .time(time)
                .book(book)
                .build();
    }
}
