package com.yangyoung.server.dto.enrollment.response;

import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.lecture.Lecture;
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
