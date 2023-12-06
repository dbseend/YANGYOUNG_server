package com.yangyoung.server.entity.taskProgress;

import com.yangyoung.server.entity.assignment.Assignment;
import com.yangyoung.server.entity.student.Student;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TaskProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;
}

