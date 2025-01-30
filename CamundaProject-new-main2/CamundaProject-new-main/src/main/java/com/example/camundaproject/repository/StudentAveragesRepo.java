package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.StudentAverages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAveragesRepo extends JpaRepository<StudentAverages, Long> {
    StudentAverages findByStudent(Student student);
}
