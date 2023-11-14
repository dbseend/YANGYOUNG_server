package com.yangyoung.server.dto.student.response;

import com.yangyoung.server.dto.enrollment.response.EnrollmentForStudentResponse;
import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String brith;
    private String phoneNumber;
    private List<LectureInfoResponse> lectures;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.grade = student.getGrade();
        this.brith = student.getBirth();
        this.phoneNumber = student.getPhoneNumber();
        if (student.getEnrollments() != null) {
            this.lectures = student.getEnrollments().stream()
                    .map(LectureInfoResponse::new)
                    .collect(Collectors.toList());
        }
    }
}

