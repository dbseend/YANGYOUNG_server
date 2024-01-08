package com.yangyoung.server.assignment.domain;

import com.yangyoung.server.group.domain.Group;
import com.yangyoung.server.student.domain.Student;
import jakarta.persistence.*;

@Entity
public class Assignment {
    /*
    - 할 일 ID (Primary Key)
    - 할 일 내용
    - 학생ID (Foreign Key, 학생 테이블 참조)
    - 반ID (Foreign Key, 반 테이블 참조)
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}
