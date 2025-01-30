package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Homework;
import com.example.camundaproject.repository.HomeworkRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sendHomework")
public class SendHomework implements JavaDelegate {
    @Autowired
    private HomeworkRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long id = (Long) delegateExecution.getVariable("id");
        Homework homework = repo.getById(id);
        boolean first = (boolean) delegateExecution.getVariable("first");
        boolean second = (boolean) delegateExecution.getVariable("second");
        homework.setAnswersOne(first);
        homework.setAnswersTwo(second);
        repo.save(homework);

    }
}
