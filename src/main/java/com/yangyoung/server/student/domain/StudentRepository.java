package com.yangyoung.server.student.domain;

import com.yangyoung.server.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
