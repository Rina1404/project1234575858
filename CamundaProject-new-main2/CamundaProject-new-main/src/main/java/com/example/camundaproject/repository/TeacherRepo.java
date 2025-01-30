package com.example.camundaproject.repository;

import com.example.camundaproject.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Teacher findBySurnameTeacher(String surname);
}
