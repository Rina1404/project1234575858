package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.*;
import com.example.camundaproject.repository.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("testCheck")
public class TestCheck implements JavaDelegate {
        @Autowired
        private TestRepo repo;
        @Autowired
        private StudentRepository repository;
        @Autowired
        private TeacherRepo teacherRepo;

        @Override
        public void execute(DelegateExecution delegateExecution) throws Exception {
            String t = (String) delegateExecution.getVariable("username");
            String del = (String) delegateExecution.getVariable("paragraph");
            String surname = (String) delegateExecution.getVariable("studentSurname");
            Teacher teacher = teacherRepo.findBySurnameTeacher(t);
            Subject subject = teacher.getSubject();
            Student student = repository.findBySurnameStudent(surname);
            Test test = new Test();

            if (del.equals("First_paragraph")) {
                test = repo.findFirstByTitleAndSubjectAndStudent("Контрольная работа по параграфу 1:", subject, student);
            } else {
                test = repo.findFirstByTitleAndSubjectAndStudent("Контрольная работа по параграфу 2:", subject, student);
            }

            delegateExecution.setVariable("id", test.getId());
            delegateExecution.setVariable("task", test.getTask());
            delegateExecution.setVariable("answers_1", test.getAnswers1());
            delegateExecution.setVariable("answers_2", test.getAnswers2());
            delegateExecution.setVariable("first", test.getAnswersOne());
            delegateExecution.setVariable("second", test.getAnswersTwo());

        }

}
