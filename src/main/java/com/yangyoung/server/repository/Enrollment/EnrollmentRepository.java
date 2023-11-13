package com.yangyoung.server.repository.Enrollment;

import com.yangyoung.server.entity.enrollment.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long student_id);

    List<Enrollment> findByLectureId(Long lecture_id);
}
