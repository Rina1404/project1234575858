package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Grades_Quarterly")
public class GradesQuarterly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "quarter", nullable = false)
    private int quarter;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "average_score", nullable = false)
    private double averageScore;

    @Column(name = "bonuses", nullable = false)
    private int bonuses;

    // Getters and Setters
}

