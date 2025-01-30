package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.*;
import com.example.camundaproject.repository.MarksJournalRepository;
import com.example.camundaproject.repository.StudentAveragesRepo;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.SubjectRepository;
import com.example.camundaproject.utils.Calculator;
import com.example.camundaproject.utils.StringMarks;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.jgroups.util.Average;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("marksChecker")
public class MarksChecker implements JavaDelegate {
    @Autowired
    private MarksJournalRepository repository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentAveragesRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        Student student = studentRepository.findBySurnameStudent(username);
        String subj = (String) delegateExecution.getVariable("subject");
        Subject subject = subjectRepository.findBySubjectName(subj);
        MarksJournal journal = repository.findFirstByStudentAndSubject(student, subject);
        List<MarksJournal> journals = repository.findAllByStudentAndSubject(student, subject);
        StudentAverages averages = repo.findByStudent(student);
        Integer total = 0;
        for (MarksJournal j : journals) {
            total += j.getBonuses();
        }

        averages.setTotalBonuses(total);
        repo.save(averages);
        averages.setAverageMark(Calculator.calculateAvgMark(journals));

        Teacher teacher = journal.getTeacher();
        delegateExecution.setVariable("surnameTeacher", teacher.getSurnameTeacher());
        delegateExecution.setVariable("avg", Calculator.calculateAvgMark(journals).toString());
        delegateExecution.setVariable("bonuses", total.toString());
        delegateExecution.setVariable("marks", StringMarks.getMarks(journals));


    }
}
