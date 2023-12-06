package com.yangyoung.server.entity.lectureAssignment;

import com.yangyoung.server.entity.assignment.Assignment;
import com.yangyoung.server.entity.lecture.Lecture;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LectureAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;
}
