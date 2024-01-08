package com.yangyoung.server.attendance.domain;

import com.yangyoung.server.group.domain.Group;
import com.yangyoung.server.student.domain.Student;
import jakarta.persistence.*;

@Entity
public class Attendance {
    /*
    - 출석ID (Primary Key)
    - 출결 상태 (출석, 결석 등)
    - 출결 사유
    - 학생ID (Foreign Key, 학생 테이블 참조)
    - 강의ID (Foreign Key, 강의 테이블 참조)
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer isAttended;

    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}
