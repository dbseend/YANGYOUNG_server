package com.yangyoung.server.dto.lecture;

import com.yangyoung.server.entity.enrollment.Enrollment;
import lombok.Data;

import java.util.List;

@Data
public class LectureDto {
    private Long id;
    private String name; // 강의명
    private String prof; // 강사
    private Integer type; // 강의타입(0: 전체강의, 1: 분반강의)
    private Integer lectureCondition; // 강의상황(0: 기본강의, 1: 추가강의)
    private Integer time; // 강의시간
    private String book; // 교재
    private List<Enrollment> studentList; // 강의 듣는 학생 리스트
}
