package com.yangyoung.server.entity.assignment;

import com.yangyoung.server.entity.lecture.Lecture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 과제명
    private Integer progress; // 과제 진행률 - (시작 전, 진행 중, 완료)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Lecture lecture;

    @Builder
    public Assignment(String name, Integer progress) {
        this.name = name;
        this.progress = progress;
    }
}
