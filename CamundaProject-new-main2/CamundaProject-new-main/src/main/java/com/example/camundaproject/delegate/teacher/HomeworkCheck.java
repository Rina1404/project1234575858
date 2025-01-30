package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.*;
import com.example.camundaproject.repository.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("homeworkCheck")
public class HomeworkCheck implements JavaDelegate {
    @Autowired
    private HomeworkRepo repo;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String del = (String) delegateExecution.getVariable("paragraph");
        String t = (String) delegateExecution.getVariable("username");
        String surname = (String) delegateExecution.getVariable("studentSurname");
        Teacher teacher = teacherRepo.findBySurnameTeacher(t);
        Subject subject = teacher.getSubject();
        Student student = repository.findBySurnameStudent(surname);
        Homework homework = new Homework();
        if (del.equals("First_paragraph")) {
            homework = repo.findFirstByTitleAndSubjectAndStudent("Домашнее задание по параграфу 1:", subject, student);
        } else {
            homework = repo.findFirstByTitleAndSubjectAndStudent("Домашнее задание по параграфу 2:", subject, student);
        }

        delegateExecution.setVariable("id", homework.getId());
        delegateExecution.setVariable("task", homework.getQuestions());
        delegateExecution.setVariable("answers_1", homework.getAnswers1());
        delegateExecution.setVariable("answers_2", homework.getAnswers2());
        delegateExecution.setVariable("first", homework.getAnswersOne());
        delegateExecution.setVariable("second", homework.getAnswersTwo());

    }
}
