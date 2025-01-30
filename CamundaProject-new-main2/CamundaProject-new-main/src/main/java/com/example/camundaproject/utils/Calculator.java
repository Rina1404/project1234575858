package com.example.camundaproject.utils;

import com.example.camundaproject.entity.AttendanceJournal;
import com.example.camundaproject.entity.MarksJournal;

import java.util.List;

public class Calculator {

    public static Double calculateAvgMark(List<MarksJournal> marksJournalList){
        double sum = 0.0;
        for (MarksJournal score : marksJournalList) {
            sum += score.getMark();
        }
        return sum / marksJournalList.size();
    }

    public static Double calcTotalMissTime(List<AttendanceJournal> journals){
        Double total = 0.0;

        for (AttendanceJournal j:journals) {
            total += j.getNumberOfHours();
        }

        return total;

    }

    public static Integer calcTotalMissDay(List<AttendanceJournal> journals){
        int total = 0;

        for (AttendanceJournal j:journals) {
            if (j.isMissDay()) total += 1;
        }

        return total;

    }
}
