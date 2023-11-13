package com.yangyoung.server.dto.lecture.response;

import com.yangyoung.server.dto.enrollment.response.EnrollmentForLectureResponse;
import com.yangyoung.server.entity.enrollment.Enrollment;
import lombok.Data;

import java.util.List;

@Data
public class LectureResponse {
    private Long id;
    private String name;
    private String prof;
    private Integer type;
    private Integer lecture_condition;
    private Integer time;
    private String book;
    private List<EnrollmentForLectureResponse> enrolledStudents;
}
