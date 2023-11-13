package com.yangyoung.server.entity.enrollment;

import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.student.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id") //student_id 라는 foreign key 로 student 와 연결
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lecture_id") //lecture_id 라는 foreign key 로 lecture 과 연결
    private Lecture lecture;

}
