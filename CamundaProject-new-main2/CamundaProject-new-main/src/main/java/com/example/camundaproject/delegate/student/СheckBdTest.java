package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Homework;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import com.example.camundaproject.entity.Test;
import com.example.camundaproject.repository.HomeworkRepo;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.SubjectRepository;
import com.example.camundaproject.repository.TestRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("checkBdTest")
public class СheckBdTest implements JavaDelegate {
    @Autowired
    private TestRepo repo;
    @Autowired
    private SubjectRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        Student student = studentRepository.findBySurnameStudent(username);
        Test test = new Test();
        String del = (String) delegateExecution.getVariable("paragraph");
        if (del.equals("First_paragraph")) {
            Subject subject = repository.findBySubjectName((String) delegateExecution.getVariable("subject"));
            test = repo.findFirstByTitleAndSubjectAndStudent("Контрольная работа по параграфу 1:", subject, student);
        } else {
            Subject subject = repository.findBySubjectName((String) delegateExecution.getVariable("subject"));
            test = repo.findFirstByTitleAndSubjectAndStudent("Контрольная работа по параграфу 2:", subject, student);
        }

        delegateExecution.setVariable("id", test.getId());
        delegateExecution.setVariable("task", test.getTask());
        delegateExecution.setVariable("answers_1", test.getAnswers1());
        delegateExecution.setVariable("answers_2", test.getAnswers2());
    }
}
