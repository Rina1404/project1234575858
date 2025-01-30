package com.example.camundaproject.delegate.teacher;

import com.example.camundaproject.entity.Material;
import com.example.camundaproject.entity.Student;
import com.example.camundaproject.entity.Teacher;
import com.example.camundaproject.repository.MaterialRepo;
import com.example.camundaproject.repository.StudentRepository;
import com.example.camundaproject.repository.TeacherRepo;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("addMaterial")
public class AddMaterial implements JavaDelegate {
    @Autowired
    private MaterialRepo repo;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String title = (String) delegateExecution.getVariable("title_material");
        String text = (String) delegateExecution.getVariable("text_material");
        String surname = (String) delegateExecution.getVariable("studentSurname");
        String username = (String) delegateExecution.getVariable("username");

        Student student = repository.findBySurnameStudent(surname);
        Teacher teacher = teacherRepo.findBySurnameTeacher(username);
        Material material = new Material();
        Material m = repo.findBySubjectAndStudent(teacher.getSubject(), student);
        if (m != null){
            repo.delete(m);
        }

        material.setStudent(student);
        material.setSubject(teacher.getSubject());
        material.setTitle(title);
        material.setText(text);

        repo.save(material);

    }
}
