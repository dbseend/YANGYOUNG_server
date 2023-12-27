package com.yangyoung.server.controller.student;

import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.request.StudentInfoUpdateRequest;
import com.yangyoung.server.dto.student.response.StudentInfoResponse;
import com.yangyoung.server.dto.student.response.StudentResponse;
import com.yangyoung.server.dto.student.response.StudentTodayScheduleResponse;
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

    @GetMapping("/today/{studentId}")
    private ResponseEntity<List<StudentTodayScheduleResponse>> todaySchedule(@PathVariable Long studentId) {
        List<StudentTodayScheduleResponse> responses = studentService.todaySchedule(studentId);

        return ResponseEntity.ok()
                .body(responses);
    }
}
