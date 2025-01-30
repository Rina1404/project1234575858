package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.AttendanceJournal;
import com.example.camundaproject.entity.MarksJournal;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.AttendanceJournalRepo;
import com.example.camundaproject.repository.MarksJournalRepository;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("omissionInsert")
public class OmissionInsert implements JavaDelegate {
    @Autowired
    private AttendanceJournalRepo journalRepo;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepo repo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String h = (String) delegateExecution.getVariable("hours");
        Double hours = Double.parseDouble(h);

        String date = (String) delegateExecution.getVariable("date");
        String username = (String) delegateExecution.getVariable("username");
        String surname = (String) delegateExecution.getVariable("studentSurname");
        Student student = repository.findBySurnameStudent(surname);
        Teacher teacher = repo.findBySurnameTeacher(username);
        AttendanceJournal journal = new AttendanceJournal();

        journal.setDateAssigned(date);
        journal.setMissDay(true);
        journal.setNumberOfHours(hours);
        journal.setTeacher(teacher);
        journal.setStudent(student);
        journal.setSubject(teacher.getSubject());

        journalRepo.save(journal);


    }
}
