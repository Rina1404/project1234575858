package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectName(String name);
}
