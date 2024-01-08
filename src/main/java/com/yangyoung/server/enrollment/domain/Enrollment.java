package com.yangyoung.server.enrollment.domain;

import com.yangyoung.server.lecture.domain.Lecture;
import com.yangyoung.server.student.domain.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id") //student_id 라는 foreign key 로 student 와 연결
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id") //lecture_id 라는 foreign key 로 lecture 과 연결
    private Lecture lecture;
}
