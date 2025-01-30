package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.MarksJournal;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.MarksJournalRepository;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component("markGrade")
public class MarkGrade implements JavaDelegate {
    @Autowired
    private MarksJournalRepository marksJournalRepository;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Integer mark = (Integer) delegateExecution.getVariable("markTeacher");
        String date = (String) delegateExecution.getVariable("date");
        String username = (String) delegateExecution.getVariable("username");
        String surname = (String) delegateExecution.getVariable("studentSurname");
        Student student = repository.findBySurnameStudent(surname);
        Teacher teacher = repo.findBySurnameTeacher(username);
        MarksJournal journal = new MarksJournal();


        journal.setSubject(teacher.getSubject());
        journal.setTeacher(teacher);
        journal.setStudent(student);
        journal.setMark(mark);
        journal.setDateAssigned(date);
        journal.setBonuses(2);

        marksJournalRepository.save(journal);


    }
}
