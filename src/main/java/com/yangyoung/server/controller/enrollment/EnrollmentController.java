package com.yangyoung.server.controller.enrollment;

import com.yangyoung.server.dto.enrollment.request.EnrollmentCreateRequest;
import com.yangyoung.server.dto.enrollment.response.EnrollmentForLectureResponse;
import com.yangyoung.server.dto.enrollment.response.EnrollmentForStudentResponse;
import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.service.enrollment.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/create")
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody EnrollmentCreateRequest request) {
        Enrollment enrollment = enrollmentService.createEnrollment(request);

        return ResponseEntity.ok()
                .body(enrollment);
    }

    @GetMapping("/findStudent/{student_id}")
    public ResponseEntity<EnrollmentForStudentResponse> findLecturesForStudent(@PathVariable Long student_id) {
        EnrollmentForStudentResponse response = enrollmentService.findLecturesForStudent(student_id);

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/findLecture/{lecture_id}")
    public ResponseEntity<EnrollmentForLectureResponse> findStudentsForLecture(@PathVariable Long lecture_id) {
        EnrollmentForLectureResponse response = enrollmentService.findStudentsForLecture(lecture_id);

        return ResponseEntity.ok()
                .body(response);
    }
}
