package com.yangyoung.server.entity.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yangyoung.server.entity.enrollment.Enrollment;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
//@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 학생 이름
    private Integer gender; // 성별
    private Integer grade; // 학년
    private String birth; // 생일
    private String phoneNumber; // 전화번호
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>(); // 수강 과목


    @Builder
    public Student(String name, Integer gender, Integer grade, String birth, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

    public void update(Integer grade, String phoneNumber) {
        if (grade != -1) {
            this.grade = grade;
        }
        if (phoneNumber != null) {
            this.phoneNumber = phoneNumber;
        }
    }
}
