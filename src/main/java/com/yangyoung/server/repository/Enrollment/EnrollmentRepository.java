package com.yangyoung.server.repository.Enrollment;

import com.yangyoung.server.entity.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
