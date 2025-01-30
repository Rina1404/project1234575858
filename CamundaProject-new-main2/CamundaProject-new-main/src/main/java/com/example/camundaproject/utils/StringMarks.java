package com.example.camundaproject.utils;

import com.example.camundaproject.entity.MarksJournal;
import com.example.camundaproject.entity.StudentAverages;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class StringMarks {
    public static String getMarks(List<MarksJournal> services){
        StringBuilder builder = new StringBuilder();

        for (MarksJournal marksJournal : services) {
            builder.append(marksJournal.getMark()).append(" ");
        }

        return builder.toString();
    }
}
