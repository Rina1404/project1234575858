package com.example.camundaproject.repository;

import com.example.camundaproject.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassEntityRepo extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassLetterAndAndClassNumber(String letter, int numb);
}
