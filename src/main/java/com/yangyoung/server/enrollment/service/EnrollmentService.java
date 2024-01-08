package com.yangyoung.server.enrollment.service;

import com.yangyoung.server.enrollment.dto.request.EnrollmentCreateRequest;
import com.yangyoung.server.enrollment.dto.response.EnrollmentForLectureResponse;
import com.yangyoung.server.enrollment.dto.response.EnrollmentForStudentResponse;
import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.lecture.domain.Lecture;
import com.yangyoung.server.student.domain.Student;
import com.yangyoung.server.enrollment.domain.EnrollmentRepository;
import com.yangyoung.server.lecture.domain.LectureRepository;
import com.yangyoung.server.student.domain.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    @Transactional
    public Enrollment createEnrollment(EnrollmentCreateRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 강좌입니다."));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setLecture(lecture);

        return enrollmentRepository.save(enrollment);
    }

    @Transactional
    public EnrollmentForStudentResponse findLecturesForStudent(Long student_id) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(student_id);
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < enrollments.size(); i++) {
            lectures.add(enrollments.get(i).getLecture());
        }
        EnrollmentForStudentResponse response = new EnrollmentForStudentResponse();
        response.setLectureList(lectures);

        return response;
    }

    @Transactional
    public EnrollmentForLectureResponse findStudentsForLecture(Long lecture_id) {
        List<Enrollment> enrollments = enrollmentRepository.findByLectureId(lecture_id);
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < enrollments.size(); i++) {
            students.add(enrollments.get(i).getStudent());
        }
        EnrollmentForLectureResponse response = new EnrollmentForLectureResponse();
        response.setStudentList(students);

        return response;
    }
}
