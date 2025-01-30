package com.example.camundaproject.utils;

import com.example.camundaproject.entity.AttendanceJournal;
import com.example.camundaproject.entity.MarksJournal;

import java.util.List;

public class StringOmissions {

    public static String getOmissions(List<AttendanceJournal> services){
        StringBuilder builder = new StringBuilder();

        for (AttendanceJournal journal : services) {
            builder.append(journal.getDateAssigned()).append(" - ").append(journal.getNumberOfHours()).append(", ");
        }

        return builder.toString();
    }
}
