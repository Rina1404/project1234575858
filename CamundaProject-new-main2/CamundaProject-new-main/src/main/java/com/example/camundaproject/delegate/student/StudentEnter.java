package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Student;
import com.example.camundaproject.repository.StudentRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("studentEnter")
public class StudentEnter implements JavaDelegate {
    @Autowired
    private StudentRepository repository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String password = (String) delegateExecution.getVariable("password");

        Student student = repository.findBySurnameStudent(username);

        if (student == null || !student.getPassword().equals(password)){
            throw new  Exception("there is no such student");
        }
    }
}
