package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("teacherEnter")
public class TeacherEnter implements JavaDelegate {
    @Autowired
    private TeacherRepo repository;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        String password = (String) delegateExecution.getVariable("password");

        Teacher teacher = repository.findBySurnameTeacher(username);

        if (teacher == null || !teacher.getPassword().equals(password)){
            throw new  Exception("there is no such teacher");
        }
    }
}
