package com.example.camundaproject.repository;

import com.example.camundaproject.entity.MarksJournal;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksJournalRepository extends JpaRepository<MarksJournal, Long> {
    MarksJournal findFirstByStudentAndSubject(Student student, Subject subject);
    List<MarksJournal> findAllByStudentAndSubject(Student student, Subject subject);
}
