package com.example.camundaproject.repository;

import com.example.camundaproject.entity.AttendanceStudent;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceStudentRepo extends JpaRepository<AttendanceStudent, Long> {
    AttendanceStudent findByStudentAndSubject(Student student, Subject subject);
}
