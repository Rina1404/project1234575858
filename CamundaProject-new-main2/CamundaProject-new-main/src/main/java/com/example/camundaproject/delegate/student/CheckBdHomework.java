package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Homework;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import com.example.camundaproject.repository.HomeworkRepo;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.SubjectRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("checkBdHomework")
public class CheckBdHomework implements JavaDelegate {
    @Autowired
    private HomeworkRepo repo;
    @Autowired
    private SubjectRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        Homework homework = new Homework();
        Student student = studentRepository.findBySurnameStudent(username);
        String del = (String) delegateExecution.getVariable("paragraph");
        if (del.equals("First_paragraph")) {
            Subject subject = repository.findBySubjectName(
                    (String) delegateExecution.getVariable("subject"));
        homework = repo.findFirstByTitleAndSubjectAndStudent("Домашнее задание по параграфу 1:", subject, student);
        } else {
            Subject subject = repository.findBySubjectName(
                    (String) delegateExecution.getVariable("subject"));
            homework = repo.findFirstByTitleAndSubjectAndStudent("Домашнее задание по параграфу 2:", subject, student);
        }

        delegateExecution.setVariable("id", homework.getId());
        delegateExecution.setVariable("task", homework.getQuestions());
        delegateExecution.setVariable("answers_1", homework.getAnswers1());
        delegateExecution.setVariable("answers_2", homework.getAnswers2());
    }
}
