package com.example.camundaproject.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student_Averages")
public class StudentAverages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "average_mark", nullable = false)
    private Double averageMark;

    @Column(name = "total_bonuses", nullable = false)
    private Integer totalBonuses;

    // Getters and Setters

    // ... (generate getters and setters)
}
