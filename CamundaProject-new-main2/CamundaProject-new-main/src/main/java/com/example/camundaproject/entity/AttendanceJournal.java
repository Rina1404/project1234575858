package com.example.camundaproject.entity;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "Attendance_Journal")
public class AttendanceJournal {
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

    @Column(name = "miss_day", nullable = false)
    private boolean missDay;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "number_of_hours", nullable = false)
    private double numberOfHours;

    // Getters and Setters
}
