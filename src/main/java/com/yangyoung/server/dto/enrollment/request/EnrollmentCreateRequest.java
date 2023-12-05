package com.yangyoung.server.dto.enrollment.request;

import lombok.Data;

@Data
public class EnrollmentCreateRequest {
    private Long studentId;
    private Long lectureId;
}
