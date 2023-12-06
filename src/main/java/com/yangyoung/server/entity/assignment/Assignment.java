package com.yangyoung.server.entity.assignment;

import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.lectureAssignment.LectureAssignment;
import com.yangyoung.server.entity.taskProgress.TaskProgress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private List<TaskProgress> taskProgresses = new ArrayList<>();
    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private List<LectureAssignment> lectureAssignments = new ArrayList<>();
}
