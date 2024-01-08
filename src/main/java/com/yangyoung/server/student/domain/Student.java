package com.yangyoung.server.student.domain;

import com.yangyoung.server.assignment.domain.Assignment;
import com.yangyoung.server.attendance.domain.Attendance;
import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.group.domain.Group;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Student {
    /*
    - 학생ID (Primary Key)
    - 이름
    - 학교
    - 학년
    - 연락처
    - 반ID (Foreign Key, 반 테이블 참조, Unique Constraint)
    - 출석ID (Foreign Key, 출석 테이블 참조)
    */

    @Id
    private Long id;

    private String name;

    private String school;

    private String grade;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Assignment> assignmentList;

}
