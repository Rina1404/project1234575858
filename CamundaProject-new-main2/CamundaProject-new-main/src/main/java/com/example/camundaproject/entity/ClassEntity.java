package com.example.camundaproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_number", nullable = false)
    private int classNumber;

    @Column(name = "class_letter")
    private String classLetter;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    // Getters and Setters
}
