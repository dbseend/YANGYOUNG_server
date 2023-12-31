package com.yangyoung.server.lecture.dto.response;

import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.lecture.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureInfoResponse {
    private Long id;
    private String name;
    private String prof;
    private Integer type;
    private Integer lectureCondition;
    private Integer day;
    private Integer time;
    private String book;

    public LectureInfoResponse(Lecture lecture) {
        this.id = lecture.getId();
        this.name = lecture.getName();
        this.prof = lecture.getProf();
        this.type = lecture.getType();
        this.lectureCondition = lecture.getLectureCondition();
        this.day = lecture.getDay();
        this.time = lecture.getTime();
        this.book = lecture.getBook();
    }

    public LectureInfoResponse(Enrollment enrollment) {
    }
}
