package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
    Test findFirstByTitleAndSubjectAndStudent(String title, Subject subject, Student student);
    Test findFirstBySubjectAndStudent(Subject subject, Student student);
}
