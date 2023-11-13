package com.yangyoung.server.dto.lecture.response;

import com.yangyoung.server.entity.enrollment.Enrollment;

import java.util.List;

public class LectureResponse {
    private Long id;
    private String name;
    private String prof;
    private Integer type;
    private Integer condition;
    private Integer time;
    private String book;
    private List<Enrollment> enrolledStudents;
}
