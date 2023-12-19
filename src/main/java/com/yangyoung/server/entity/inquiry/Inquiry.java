package com.yangyoung.server.entity.inquiry;

import com.yangyoung.server.entity.student.Student;
import jakarta.persistence.*;
import lombok.Data;

/*
자료이름, 수량, 요청한 학생 이름, 처리한요청사항인지아닌지
*/
@Entity
@Data
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    boolean isDone;
}
