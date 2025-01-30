package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("searchStudent")
public class SearchStudent implements JavaDelegate {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String surname = (String) delegateExecution.getVariable("studentSurname");
       /* String t = (String) delegateExecution.getVariable("username");
        Teacher teacher = repo.findBySurnameTeacher(t);
        Subject subject = teacher.getSubject();*/

        Student student = repository.findBySurnameStudent(surname);
        if (student == null) {
            throw new Exception("there is no such student");
        }

    }
}
