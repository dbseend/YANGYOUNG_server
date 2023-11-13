package com.yangyoung.server.service.lecture;

import com.yangyoung.server.dto.lecture.request.LectureInfoCreateRequest;
import com.yangyoung.server.dto.lecture.request.LectureInfoUpdateRequest;
import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.repository.lecture.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository     lectureRepository;

    @Transactional
    public Lecture createLecture(LectureInfoCreateRequest request) {
        return lectureRepository.save(request.toEntity());
    }

    @Transactional
    public List<Lecture> findAllLectures() {
        return lectureRepository.findAll();
    }

    @Transactional
    public Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));
    }

    @Transactional
    public Lecture updateLecture(Long lectureId, LectureInfoUpdateRequest request) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));

        lecture.update(request.getName(), request.getProf(), request.getType(),
                request.getCondition(), request.getTime(), request.getBook());

        return lectureRepository.save(lecture);
    }

    @Transactional
    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }


}
