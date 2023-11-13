package com.yangyoung.server.dto.student.request;

import com.yangyoung.server.entity.student.Student;

public class StudentInfoCreateRequest {
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;

    public Student toEntity() {
        return Student.builder()
                .name(name)
                .gender(gender)
                .grade(grade)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .build();
    }
}
