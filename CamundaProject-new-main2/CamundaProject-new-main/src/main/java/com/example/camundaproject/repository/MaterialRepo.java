package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Material;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepo extends JpaRepository<Material, Long> {
    Material findBySubjectAndStudent(Subject subject, Student student);

}
