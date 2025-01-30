package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Attendance_Students")
public class AttendanceStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    @Column(name = "missed_days", nullable = false)
    private int missedDays;

    @Column(name = "total_number_of_hours", nullable = false)
    private double numberOfHours;

}

