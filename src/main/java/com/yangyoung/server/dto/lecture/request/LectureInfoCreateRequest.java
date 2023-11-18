package com.yangyoung.server.dto.lecture.request;

import com.yangyoung.server.entity.lecture.Lecture;
import lombok.Data;

@Data
public class LectureInfoCreateRequest {
    private String name;
    private String prof;
    private Integer type;
    private Integer lectureCondition;
    private Integer time;
    private String book;

    public Lecture toEntity() {
        return Lecture.builder()
                .name(name)
                .prof(prof)
                .type(type)
                .lecture_condition(lectureCondition)
                .time(time)
                .book(book)
                .build();
    }
}
