package com.yangyoung.server.dto.enrollment;

import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.student.Student;
import lombok.Data;


@Data
public class EnrollmentDto {
    private Long id;
    private Student student;
    private Lecture lecture;
}
