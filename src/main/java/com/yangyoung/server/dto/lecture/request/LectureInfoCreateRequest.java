package com.yangyoung.server.dto.lecture.request;

import com.yangyoung.server.entity.lecture.Lecture;
import lombok.Data;

@Data
public class LectureInfoCreateRequest {
    private String name; // 강의명
    private String prof; // 강사
    private Integer room; // 강의실
    private Integer type; // 강의타입(0: 전체강의, 1: 분반강의)
    private Integer lectureCondition; // 강의상황(0: 기본강의, 1: 추가강의)
    private Integer AB; // A반 B반
    private Integer time; // 강의시간 (5:30~6:55, 7:00~8:25, 8:30~9:55)
    private String book; // 교재

    public Lecture toEntity() {
        return Lecture.builder()
                .name(name)
                .prof(prof)
                .room(room)
                .type(type)
                .lecture_condition(lectureCondition)
                .AB(AB)
                .time(time)
                .book(book)
                .build();
    }
}
