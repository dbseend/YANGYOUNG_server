package com.yangyoung.server.repository.lecture;

import com.yangyoung.server.entity.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
