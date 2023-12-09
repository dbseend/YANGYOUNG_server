package com.yangyoung.server.dto.student.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTodayScheduleResponse {
    private String lectureName;
    private Integer time;
    private Integer room;
}
