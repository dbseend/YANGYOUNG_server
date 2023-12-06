package com.yangyoung.server.entity.lecture;

import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.lectureAssignment.LectureAssignment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 강의명
    private String prof; // 강사
    private Integer room; // 강의실
    private Integer type; // 강의타입(0: 전체강의, 1: 분반강의)
    private Integer lectureCondition; // 강의상황(0: 기본강의, 1: 추가강의)
    private Integer AB; // A반 B반
    private Integer time; // 강의시간 (5:30~6:55, 7:00~8:25, 8:30~9:55)
    private String book; // 교재
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Enrollment> students; // 강의 듣는 학생 리스트
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<LectureAssignment> assignments; // 과제 리스트

    @Builder
    public Lecture(String name, String prof, Integer room, Integer type, Integer lecture_condition, Integer AB, Integer time, String book) {
        this.name = name;
        this.prof = prof;
        this.room = room;
        this.type = type;
        this.lectureCondition = lecture_condition;
        this.AB = AB;
        this.time = time;
        this.book = book;
    }
}

