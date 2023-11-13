package com.yangyoung.server.dto.enrollment.response;

import com.yangyoung.server.entity.lecture.Lecture;
import lombok.Data;

import java.util.List;

@Data
public class EnrollmentForStudentResponse {
    private List<Lecture> lectureList;

}
