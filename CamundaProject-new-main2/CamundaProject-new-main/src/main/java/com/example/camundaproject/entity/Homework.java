package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "homework_id", nullable = false)
    private Long homeworkId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String questions;

    @Column(nullable = false)
    private String answers1;

    @Column(name = "answers_one")
    private Boolean answersOne;

    @Column(nullable = false)
    private String answers2;

    @Column(name = "answers_two")
    private Boolean answersTwo;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // геттеры и сеттеры
}

