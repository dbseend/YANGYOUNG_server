package com.yangyoung.server.repository.student;

import com.yangyoung.server.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
