package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "Marks_Journal")
public class MarksJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "date_assigned", nullable = false)
    private String dateAssigned;

    @Column(name = "mark", nullable = false)
    private Integer mark;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "bonuses")
    private Integer bonuses;

    // Getters and Setters
}
