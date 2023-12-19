package com.yangyoung.server.entity.student;

import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.taskProgress.TaskProgress;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Student {
    @Id
    private Long id;
    private String name; // 학생 이름
    private Integer gender; // 성별
    private Integer grade; // 학년
    private String birth; // 생일
    private String phoneNumber; // 전화번호
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments = new ArrayList<>(); // 수강 과목
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<TaskProgress> taskProgresses = new ArrayList<>();


    @Builder
    public Student(String name, Integer gender, Integer grade, String birth, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }
}
