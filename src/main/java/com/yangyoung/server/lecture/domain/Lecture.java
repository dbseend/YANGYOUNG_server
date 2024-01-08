package com.yangyoung.server.lecture.domain;

import com.yangyoung.server.enrollment.domain.Enrollment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Lecture {
    /*
    - 수업ID (Primary Key)
    - 수업명
    - 수업 요일
    - 강사
    - 시간
    - 강의실
    - 반ID (Foreign Key, 반 테이블 참조)
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer day;

    private Integer time;

    private Integer room;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Enrollment> students;

}

