package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.ClassEntity;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.ClassEntityRepo;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("searchClasses")
public class SearchClasses implements JavaDelegate {
    @Autowired
    private ClassEntityRepo repo;
    @Autowired
    private TeacherRepo repository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Integer number = (Integer) delegateExecution.getVariable("Class_numb");
        String letter = (String) delegateExecution.getVariable("Class_letter");
        String t = (String) delegateExecution.getVariable("username");

        Teacher teacher = repository.findBySurnameTeacher(t);

        if (number > 11 || number < 1) {
            throw new Exception("There is no such class");
        } else {
            ClassEntity classEntity = repo.findByClassLetterAndAndClassNumber(letter, number);
            if (classEntity == null || !classEntity.getTeacher().equals(teacher))
                throw new Exception("Teacher do not teach such class");
        }

    }
}
