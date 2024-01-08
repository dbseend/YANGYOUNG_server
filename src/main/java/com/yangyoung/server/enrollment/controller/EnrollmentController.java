package com.yangyoung.server.enrollment.controller;

import com.yangyoung.server.enrollment.dto.request.EnrollmentCreateRequest;
import com.yangyoung.server.enrollment.dto.response.EnrollmentForLectureResponse;
import com.yangyoung.server.enrollment.dto.response.EnrollmentForStudentResponse;
import com.yangyoung.server.enrollment.domain.Enrollment;
import com.yangyoung.server.enrollment.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
@CrossOrigin(origins = "http://localhost:3000")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("")
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody EnrollmentCreateRequest request) {
        Enrollment enrollment = enrollmentService.createEnrollment(request);

        return ResponseEntity.ok()
                .body(enrollment);
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<EnrollmentForStudentResponse> findLecturesForStudent(@PathVariable Long student_id) {
        EnrollmentForStudentResponse response = enrollmentService.findLecturesForStudent(student_id);

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/{lecture_id}")
    public ResponseEntity<EnrollmentForLectureResponse> findStudentsForLecture(@PathVariable Long lecture_id) {
        EnrollmentForLectureResponse response = enrollmentService.findStudentsForLecture(lecture_id);

        return ResponseEntity.ok()
                .body(response);
    }
}
