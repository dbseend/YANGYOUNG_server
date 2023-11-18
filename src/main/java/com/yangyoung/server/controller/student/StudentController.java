package com.yangyoung.server.controller.student;

import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.request.StudentInfoUpdateRequest;
import com.yangyoung.server.dto.student.response.StudentInfoResponse;
import com.yangyoung.server.dto.student.response.StudentResponse;
import com.yangyoung.server.entity.student.Student;
import com.yangyoung.server.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("")
    public ResponseEntity<Student> createStudent(@RequestBody StudentInfoCreateRequest request) {
        Student student = studentService.createStudent(request);

        return ResponseEntity.ok()
                .body(student);
    }

    @GetMapping("")
    public ResponseEntity<List<StudentInfoResponse>> findAllStudent() {
        List<StudentInfoResponse> students = studentService.findAllStudents()
                .stream()
                .map(StudentInfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> findStudent(@PathVariable Long studentId) {
        StudentResponse response = studentService.findLecturesForStudent(studentId);

        return ResponseEntity.ok()
                .body(response);
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody StudentInfoUpdateRequest request) {
        Student student = studentService.updateStudent(studentId, request);

        return ResponseEntity.ok()
                .body(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);

        return ResponseEntity.noContent()
                .build();
    }
}
