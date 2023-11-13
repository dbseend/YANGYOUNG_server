package com.yangyoung.server.dto.lecture.response;

import com.yangyoung.server.entity.lecture.Lecture;
import lombok.Data;

@Data
public class LectureInfoResponse {
    private Long id;
    private String name;
    private String prof;
    private Integer type;
    private Integer lecture_condition;
    private Integer time;
    private String book;

    public LectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.prof = lecture.getProf();
        this.type = lecture.getType();
        this.lecture_condition = lecture.getLecture_condition();
        this.time = lecture.getTime();
        this.book = lecture.getBook();
    }
}
