package com.yangyoung.server.group.domain;

import com.yangyoung.server.assignment.domain.Assignment;
import com.yangyoung.server.attendance.domain.Attendance;
import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.student.domain.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Group {

    /*
    - 반ID (Primary Key)
    - 반 이름
    - 담임 선생님
    - 학생ID (Foreign Key, 학생 테이블 참조, Unique Constraint)
    - 강의ID (Foreign Key, 강의 테이블 참조)
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String teacher;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> studentList;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;

}
