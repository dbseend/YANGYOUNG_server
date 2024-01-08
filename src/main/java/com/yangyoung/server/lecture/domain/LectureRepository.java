package com.yangyoung.server.lecture.domain;

import com.yangyoung.server.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
