package com.yangyoung.server.enrollment.dto.response;

import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.lecture.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentForStudentResponse {
    private List<Lecture> lectureList;

    public EnrollmentForStudentResponse(Enrollment enrollment) {
    }
}
