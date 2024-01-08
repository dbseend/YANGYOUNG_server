package com.yangyoung.server.enrollment.dto.request;

import lombok.Data;

@Data
public class EnrollmentCreateRequest {
    private Long studentId;
    private Long lectureId;
}
