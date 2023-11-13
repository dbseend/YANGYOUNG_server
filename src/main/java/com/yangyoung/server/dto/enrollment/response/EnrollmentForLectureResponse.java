package com.yangyoung.server.dto.enrollment.response;

import com.yangyoung.server.entity.student.Student;
import lombok.Data;

import java.util.List;

@Data
public class EnrollmentForLectureResponse {
    private List<Student> studentList;
}
