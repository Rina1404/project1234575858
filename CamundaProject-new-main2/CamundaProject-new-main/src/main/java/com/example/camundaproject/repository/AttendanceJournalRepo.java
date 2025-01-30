package com.example.camundaproject.repository;

import com.example.camundaproject.entity.AttendanceJournal;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceJournalRepo extends JpaRepository<AttendanceJournal, Long> {
    List<AttendanceJournal> findAllByStudentAndSubject(Student student, Subject subject);
}
