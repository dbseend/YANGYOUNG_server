package com.yangyoung.server.dto.lecture.response;

import com.yangyoung.server.dto.student.response.StudentInfoResponse;
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
