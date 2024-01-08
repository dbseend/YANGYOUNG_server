package com.yangyoung.server.student.dto.response;

import com.yangyoung.server.lecture.dto.response.LectureInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String brith;
    private String phoneNumber;
    private List<LectureInfoResponse> lectures;
}

