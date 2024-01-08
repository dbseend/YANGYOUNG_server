package com.yangyoung.server.lecture.dto.response;

import com.yangyoung.server.student.dto.response.StudentInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectureResponse {
    private Long id;
    private String name;
    private String prof;
    private Integer type;
    private Integer lectureCondition;
    private Integer time;
    private String book;
    private List<StudentInfoResponse> students;
}
