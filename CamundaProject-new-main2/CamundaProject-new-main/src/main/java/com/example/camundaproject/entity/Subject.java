package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name", nullable = false, unique = true)
    private String subjectName;

    // Getters and Setters
}
