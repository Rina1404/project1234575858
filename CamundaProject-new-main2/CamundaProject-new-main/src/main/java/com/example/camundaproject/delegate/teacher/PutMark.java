package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.*;
import com.example.camundaproject.repository.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;

@Component("putMark")
public class PutMark implements JavaDelegate {
    @Autowired
    private MarksJournalRepository repo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private StudentAveragesRepo averagesRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long mark = (Long) delegateExecution.getVariable("mark");
        Long bonus = (Long) delegateExecution.getVariable("bonus");
        String username = (String) delegateExecution.getVariable("username");
        Teacher teacher = teacherRepo.findBySurnameTeacher(username);
        String surname = (String) delegateExecution.getVariable("studentSurname");
        Student student = studentRepository.findBySurnameStudent(surname);
        Subject subject = teacher.getSubject();
        MarksJournal journal = new MarksJournal();
        Integer mar = mark.intValue();
        Integer b = bonus.intValue();
        StudentAverages averages = averagesRepo.findByStudent(student);

        if (averages != null){
            averages.setTotalBonuses(averages.getTotalBonuses() + b);
            averagesRepo.save(averages);
        }else {
            averages = new StudentAverages();
            averages.setTotalBonuses(b);
            averages.setAverageMark(mar.doubleValue());
            averages.setStudent(student);
            averagesRepo.save(averages);
        }

        journal.setDateAssigned(Instant.now().atZone(ZoneId.systemDefault()).toString());
        journal.setMark(mar);
        journal.setTeacher(teacher);
        journal.setStudent(student);
        journal.setSubject(subject);
        journal.setBonuses(b);


        repo.save(journal);


    }
}
