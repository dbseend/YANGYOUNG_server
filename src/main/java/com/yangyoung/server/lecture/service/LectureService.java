package com.yangyoung.server.lecture.service;

import com.yangyoung.server.lecture.dto.request.LectureInfoCreateRequest;
import com.yangyoung.server.lecture.dto.response.LectureResponse;
import com.yangyoung.server.student.dto.response.StudentInfoResponse;
import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.lecture.domain.Lecture;
import com.yangyoung.server.student.domain.Student;
import com.yangyoung.server.enrollment.domain.EnrollmentRepository;
import com.yangyoung.server.lecture.domain.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public Lecture createLecture(LectureInfoCreateRequest request) {
        return lectureRepository.save(request.toEntity());
    }

    @Transactional
    public List<Lecture> findAllLectures() {
        return lectureRepository.findAll();
    }

    @Transactional
    public LectureResponse findLecturesForStudent(Long lecture_id) {
        Lecture lecture = lectureRepository.findById(lecture_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강의입니다."));
        List<StudentInfoResponse> students = new ArrayList<>();
        List<Enrollment> enrollments = enrollmentRepository.findByLectureId(lecture_id);
        for (int i = 0; i < enrollments.size(); i++) {
            Student tempN = enrollments.get(i).getStudent();
            StudentInfoResponse tempS = new StudentInfoResponse(tempN.getId(), tempN.getName(), tempN.getGender(),
                    tempN.getGrade(), tempN.getBirth(), tempN.getPhoneNumber());
            students.add(tempS);
        }

        LectureResponse response = new LectureResponse(lecture.getId(), lecture.getName(), lecture.getProf()
                , lecture.getType(), lecture.getLectureCondition(), lecture.getTime(), lecture.getBook(), students);

        return response;
    }

    @Transactional
    public Lecture findLecture(Long lectureId) {
        return lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));
    }

//    @Transactional
//    public Lecture updateLecture(Long lectureId, LectureInfoUpdateRequest request) {
//        Lecture lecture = lectureRepository.findById(lectureId)
//                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));
//
//        lecture.update(request.getName(), request.getProf(), request.getType(),
//                request.getLectureCondition(), request.getTime(), request.getBook());
//
//        return lectureRepository.save(lecture);
//    }

    @Transactional
    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }


}
