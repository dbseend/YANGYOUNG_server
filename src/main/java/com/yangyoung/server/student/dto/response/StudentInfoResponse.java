package com.yangyoung.server.student.dto.response;

import com.yangyoung.server.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // dto 에서 어떤 역할을 했지? 왜 없을 때는 오류가 났지?
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoResponse {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String birth;
    private String phoneNumber;

    public StudentInfoResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.grade = student.getGrade();
        this.birth = student.getBirth();
        this.phoneNumber = student.getPhoneNumber();
    }
}
