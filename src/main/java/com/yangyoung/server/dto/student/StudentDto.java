package com.yangyoung.server.dto.student;

import com.yangyoung.server.entity.enrollment.Enrollment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDto {
    private Long id;
    private String name; // 학생 이름
    private Integer gender; // 성별
    private Integer grade; // 학년
    private String birth; // 생일
    private String phoneNumber; // 전화번호
    private List<Enrollment> enrollments = new ArrayList<>(); // 수강 과목
}
