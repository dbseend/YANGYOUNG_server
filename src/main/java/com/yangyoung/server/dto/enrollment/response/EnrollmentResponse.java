package com.yangyoung.server.dto.enrollment.response;

import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.student.Student;

public class EnrollmentResponse {
    private Long id;
    private Student student;
    private Lecture lecture;

}