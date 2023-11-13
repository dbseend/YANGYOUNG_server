package com.yangyoung.server.entity.lecture;

import com.yangyoung.server.entity.enrollment.Enrollment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 강의명
    private String prof; // 강사
    private Integer type; // 강의타입(0: 전체강의, 1: 분반강의)
    private Integer time; // 강의시간
    private Integer condition; // 강의상황(0: 기본강의, 1: 추가강의)
    private String book; // 교재
    //강의 듣는 학생 리스트
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL) //enrollment entity에서 lecture로 연결
    private List<Enrollment> studentList;

    @Builder
    public Lecture(String name, String prof, Integer type, Integer time, Integer condition, String book) {
        this.name = name;
        this.prof = prof;
        this.type = type;
        this.condition = condition;
        this.time = time;
        this.book = book;
    }

    public void update(String name, String prof, Integer type, Integer time, Integer condition, String book) {
        this.name = name;
        this.prof = prof;
        this.type = type;
        this.condition = condition;
        this.time = time;
        this.book = book;
    }

}
