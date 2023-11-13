package com.yangyoung.server.service.student;

import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.request.StudentInfoUpdateRequest;
import com.yangyoung.server.entity.student.Student;
import com.yangyoung.server.repository.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public Student createStudent(StudentInfoCreateRequest request) {
        return studentRepository.save(request.toEntity());
    }

    @Transactional
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student findStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));
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
