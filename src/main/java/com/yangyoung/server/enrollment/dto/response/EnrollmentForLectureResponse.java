package com.yangyoung.server.enrollment.dto.response;

import com.yangyoung.server.student.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class EnrollmentForLectureResponse {
    private List<Student> studentList;
}
