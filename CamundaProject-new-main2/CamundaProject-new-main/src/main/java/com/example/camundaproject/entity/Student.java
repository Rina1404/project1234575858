package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname_student", nullable = false)
    private String surnameStudent;

    @Column(name = "name_student", nullable = false)
    private String nameStudent;

    @Column(name = "patronymic_student", nullable = false)
    private String patronymicStudent;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassEntity classEntity;

    @Column(name = "email_student", nullable = false, unique = true)
    private String emailStudent;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "surname_parents")
    private String surnameParents;

    @Column(name = "name_parents")
    private String nameParents;

    @Column(name = "patronymic_parents")
    private String patronymicParents;

    @Column(name = "telephone_number_parents")
    private String telephoneNumberParents;

    // Getters and Setters
}
