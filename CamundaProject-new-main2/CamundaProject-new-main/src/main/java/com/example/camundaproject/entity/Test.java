package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "test_id", nullable = false)
    private Long testId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String task;

    @Column(name = "answers1", nullable = false)
    private String answers1;

    @Column(name = "answers_one")
    private Boolean answersOne;

    @Column(name = "answers2", nullable = false)
    private String answers2;

    @Column(name = "answers_two")
    private Boolean answersTwo;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // геттеры и сеттеры
}

