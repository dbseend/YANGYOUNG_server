package com.yangyoung.server.repository.assignment;

import com.yangyoung.server.entity.assignment.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
