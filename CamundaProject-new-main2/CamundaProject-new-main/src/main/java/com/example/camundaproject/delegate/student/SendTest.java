package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Homework;
import com.example.camundaproject.entity.Test;
import com.example.camundaproject.repository.HomeworkRepo;
import com.example.camundaproject.repository.TestRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sendTest")
public class SendTest implements JavaDelegate {
    @Autowired
    private TestRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long id = (Long) delegateExecution.getVariable("id");
        Test t = repo.getById(id);
        boolean first = (boolean) delegateExecution.getVariable("first");
        boolean second = (boolean) delegateExecution.getVariable("second");
        t.setAnswersOne(first);
        t.setAnswersTwo(second);
        repo.save(t);

    }
}
