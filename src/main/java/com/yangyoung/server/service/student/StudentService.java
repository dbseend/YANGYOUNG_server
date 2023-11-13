package com.yangyoung.server.service.student;

import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.request.StudentInfoUpdateRequest;
import com.yangyoung.server.entity.student.Student;
import com.yangyoung.server.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(StudentInfoCreateRequest request) {
        return studentRepository.save(request.toEntity());
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));
    }

    public Student updateStudent(Long studentId, StudentInfoUpdateRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("학생이 존재하지 않습니다."));

        student.update(request.getGrade(), request.getPhoneNumber());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
