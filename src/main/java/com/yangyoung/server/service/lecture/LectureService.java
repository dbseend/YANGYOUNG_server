package com.yangyoung.server.service.lecture;

import com.yangyoung.server.dto.lecture.request.LectureInfoCreateRequest;
import com.yangyoung.server.dto.lecture.request.LectureInfoUpdateRequest;
import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.repository.lecture.LectureRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository     lectureRepository;

    public Lecture createLecture(LectureInfoCreateRequest request) {
        return lectureRepository.save(request.toEntity());
    }

    public List<Lecture> findAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));
    }

    public Lecture updateLecture(Long lectureId, LectureInfoUpdateRequest request) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));

        lecture.update(request.getName(), request.getProf(), request.getType(),
                request.getCondition(), request.getTime(), request.getBook());

        return lectureRepository.save(lecture);
    }

    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }


}
