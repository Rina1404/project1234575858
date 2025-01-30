package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.Material;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Subject;
import com.example.camundaproject.repository.MaterialRepo;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.SubjectRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("materialSearch")
public class MaterialSearch implements JavaDelegate {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private MaterialRepo repo;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        Student student = repository.findBySurnameStudent(username);
        String subj = (String) delegateExecution.getVariable("subject");
        Subject subject = subjectRepository.findBySubjectName(subj);

        Material material = repo.findBySubjectAndStudent(subject, student);

        delegateExecution.setVariable("title", material.getTitle());
        delegateExecution.setVariable("text", material.getText());

    }
}
