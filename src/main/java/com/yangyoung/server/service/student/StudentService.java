package com.yangyoung.server.service.student;

import com.yangyoung.server.dto.lecture.response.LectureInfoResponse;
import com.yangyoung.server.dto.student.request.StudentInfoCreateRequest;
import com.yangyoung.server.dto.student.response.StudentResponse;
import com.yangyoung.server.dto.student.response.StudentTodayScheduleResponse;
import com.yangyoung.server.entity.enrollment.Enrollment;
import com.yangyoung.server.entity.lecture.Lecture;
import com.yangyoung.server.entity.student.Student;
import com.yangyoung.server.repository.enrollment.EnrollmentRepository;
import com.yangyoung.server.repository.student.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    //학생 정보 입력
    public Student createStudent(StudentInfoCreateRequest request) {
        return studentRepository.save(request.toEntity());
    }

    @Transactional
    //학생 전체 정보 조회 - 학생 정보
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    //학생 한명 정보 조회 - 학생 정보, 학생 수강 정보
    public StudentResponse findLecturesForStudent(Long student_id) {
        Student student = studentRepository.findById(student_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));

        List<LectureInfoResponse> lectures = new ArrayList<>();
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(student_id);
        for (Enrollment enrollment : enrollments) {
            Lecture tempN = enrollment.getLecture();
            LectureInfoResponse tempL = new LectureInfoResponse(tempN.getId(), tempN.getName(), tempN.getProf(),
                    tempN.getType(), tempN.getLectureCondition(), tempN.getDay(), tempN.getTime(), tempN.getBook());
            lectures.add(tempL);
        }

        StudentResponse response = new StudentResponse(student.getId(), student.getName(), student.getGender()
                , student.getGrade(), student.getBirth(), student.getPhoneNumber(), lectures);

        return response;
    }

    // 학생 오늘의 스케줄 조회
    @Transactional
    public List<StudentTodayScheduleResponse> todaySchedule(Long studentId) {
        List<StudentTodayScheduleResponse> responses = new ArrayList<>();
        LocalDate date = LocalDate.now();
        DayOfWeek today = date.getDayOfWeek();
        int dayIdx; //1: 월수금, 2: 화목


        switch (today) {
            case MONDAY, WEDNESDAY, FRIDAY -> dayIdx = 1;
            case TUESDAY, THURSDAY -> dayIdx = 2;
            default -> throw new IllegalStateException("Unexpected value: " + today);
        }
        log.info(String.valueOf(dayIdx));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        List<Enrollment> enrollments = student.getEnrollments();

        for (Enrollment enrollment : enrollments) {
            Lecture lecture = enrollment.getLecture();
            int day = lecture.getDay();
            if (day == dayIdx) {
                StudentTodayScheduleResponse temp = new StudentTodayScheduleResponse(lecture.getName(), lecture.getTime(), lecture.getRoom());
                responses.add(temp);
            }
        }

        return responses;
    }

}
