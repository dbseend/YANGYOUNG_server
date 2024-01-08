package com.yangyoung.server.enrollment.dto;

import com.yangyoung.server.lecture.domain.Lecture;
import com.yangyoung.server.student.domain.Student;
import lombok.Data;


@Data
public class EnrollmentDto {
    private Long id;
    private Student student;
    private Lecture lecture;
}
