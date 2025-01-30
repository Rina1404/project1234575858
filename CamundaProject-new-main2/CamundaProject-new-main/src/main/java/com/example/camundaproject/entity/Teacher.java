package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname_teacher", nullable = false)
    private String surnameTeacher;

    @Column(name = "name_teacher", nullable = false)
    private String nameTeacher;

    @Column(name = "patronymic_teacher", nullable = false)
    private String patronymicTeacher;

    @Column(name = "email_teacher", nullable = false)
    private String emailTeacher;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    // Getters and Setters
}
