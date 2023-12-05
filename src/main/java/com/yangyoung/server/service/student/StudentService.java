package com.yangyoung.server.service.student;

import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.request.StudentInfoUpdateRequest;
import com.yangyoung.server.dto.student.response.StudentResponse;
import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.student.Student;
import com.yangyoung.server.repository.Enrollment.EnrollmentRepository;
import com.yangyoung.server.repository.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public StudentResponse findLecturesForStudent(Long student_id) {
        Student student = studentRepository.findById(student_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        List<LectureInfoResponse> lectures = new ArrayList<>();
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(student_id);
        for (int i = 0; i < enrollments.size(); i++) {
            Lecture tempN = enrollments.get(i).getLecture();
            LectureInfoResponse tempL = new LectureInfoResponse(tempN.getId(), tempN.getName(), tempN.getProf(),
                    tempN.getType(), tempN.getLectureCondition(), tempN.getTime(), tempN.getBook());
            lectures.add(tempL);
        }

        StudentResponse response = new StudentResponse(student.getId(), student.getName(), student.getGender()
                , student.getGrade(), student.getBirth(), student.getPhoneNumber(), lectures);

        return response;
    }

    @Transactional
    public Student createStudent(StudentInfoCreateRequest request) {
        return studentRepository.save(request.toEntity());
    }

    @Transactional
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student updateStudent(Long studentId, StudentInfoUpdateRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));

        student.update(request.getGrade(), request.getPhoneNumber());

        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
