package com.yangyoung.server.dto.assignment.requeset;

import com.yangyoung.server.entity.assignment.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentCreateRequest {
    private Long lectureId; // 강의 번호
    private String name; // 과제명
}
