package com.yangyoung.server.student.dto.request;

import com.yangyoung.server.student.domain.Student;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class StudentInfoCreateRequest {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;

    public Student toEntity() {
        return Student.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .grade(grade)
                .birth(birth)
                .phoneNumber(phoneNumber)
                .build();
    }
}

