package com.yangyoung.server.dto.enrollment.request;

import com.yangyoung.server.entity.enrollment.Enrollment;
import lombok.Data;

@Data
public class EnrollmentCreateRequest {
    private Long studentId;
    private Long lectureId;
}
