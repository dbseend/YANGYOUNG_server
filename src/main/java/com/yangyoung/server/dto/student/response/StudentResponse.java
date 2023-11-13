package com.yangyoung.server.dto.student.response;

import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.student.Student;

import java.util.List;

public class StudentResponse {
    private Long id;
    private String name;
    private Integer gender;
    private Integer grade;
    private String brith;
    private String phoneNumber;
    private List<Enrollment> lectures;

    public StudentResponse(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.grade = student.getGrade();
        this.brith = student.getBirth();
        this.phoneNumber = student.getPhoneNumber();

        // if(student.getLecture() != null){
        // }
    }
}
