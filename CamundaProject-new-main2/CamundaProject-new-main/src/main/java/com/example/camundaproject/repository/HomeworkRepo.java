package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Homework;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HomeworkRepo extends JpaRepository<Homework, Long> {
    /*Homework findByTitleAndSubject(String title, Subject subject);*/
    Homework findFirstByTitleAndSubjectAndStudent(String title, Subject subject, Student student);

    Homework findFirstBySubjectAndStudent(Subject subject, Student student);


}
