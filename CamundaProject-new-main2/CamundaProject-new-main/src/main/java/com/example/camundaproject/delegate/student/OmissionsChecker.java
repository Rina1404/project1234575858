package com.example.camundaproject.delegate.student;

import com.example.camundaproject.entity.*;
import com.example.camundaproject.repository.*;
import com.example.camundaproject.utils.Calculator;
import com.example.camundaproject.utils.StringOmissions;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("omissionsChecker")
public class OmissionsChecker implements JavaDelegate {
    @Autowired
    private AttendanceStudentRepo repository;
    @Autowired
    private AttendanceJournalRepo repo;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable("username");
        Student student = studentRepository.findBySurnameStudent(username);
        String subj = (String) delegateExecution.getVariable("subject");
        Subject subject = subjectRepository.findBySubjectName(subj);
        List<AttendanceJournal> journal = repo.findAllByStudentAndSubject(student, subject);
        AttendanceStudent attendanceStudent = repository.findByStudentAndSubject(student, subject);
        if (attendanceStudent == null){
            attendanceStudent = new AttendanceStudent();
        }
        attendanceStudent.setStudent(student);
        attendanceStudent.setSubject(subject);
        attendanceStudent.setNumberOfHours(Calculator.calcTotalMissTime(journal));
        attendanceStudent.setMissedDays(Calculator.calcTotalMissDay(journal));


        delegateExecution.setVariable("missDay", attendanceStudent.getMissedDays());
        delegateExecution.setVariable("missTime", attendanceStudent.getNumberOfHours());
        delegateExecution.setVariable("date_miss", StringOmissions.getOmissions(journal));
        repository.save(attendanceStudent);



    }
}
