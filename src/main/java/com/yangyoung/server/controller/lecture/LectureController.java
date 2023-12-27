package com.yangyoung.server.controller.lecture;

import com.yangyoung.server.dto.lecture.request.LectureInfoCreateRequest;
import com.yangyoung.server.dto.lecture.request.LectureInfoUpdateRequest;
import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.dto.lecture.response.LectureResponse;
import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lectures")
@CrossOrigin(origins = "http://localhost:3000")
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("")
    public ResponseEntity<Lecture> createLecture(@RequestBody LectureInfoCreateRequest request) {
        Lecture lecture = lectureService.createLecture(request);

        return ResponseEntity.ok()
                .body(lecture);
    }

    @GetMapping("")
    public ResponseEntity<List<LectureInfoResponse>> findAllLecture() {
        List<LectureInfoResponse> lectures = lectureService.findAllLectures()
                .stream()
                .map(LectureInfoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(lectures);
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureResponse> findLecture(@PathVariable Long lectureId) {
        LectureResponse response = lectureService.findLecturesForStudent(lectureId);

        return ResponseEntity.ok()
                .body(response);
    }

//    @PatchMapping("/{lectureId}")
//    public ResponseEntity<Lecture> updateLecture(@PathVariable Long lectureId, @RequestBody LectureInfoUpdateRequest request) {
//        Lecture lecture = lectureService.updateLecture(lectureId, request);
//
//        return ResponseEntity.ok()
//                .body(lecture);
//    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<Void> deleteLecture(@PathVariable Long lectureId) {
        lectureService.deleteLecture(lectureId);

        return ResponseEntity.noContent()
                .build();
    }
}