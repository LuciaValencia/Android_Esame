package com.example.android_esame.DB;

import android.provider.BaseColumns;

public final class Contract {

    // To prevent someone from accidentally instantiating the Lesson class, make the constructor private.
    private Contract(/*Courses course, Professor prof*/) {
    }

    /* Inner class that defines the table contents */
    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "Contract";
        public static final String COLUMN_NAME_TITLE = "Course";
        public static final String COLUMN_NAME_SUBTITLE = "Professors";
       // public static final String COLUMN_NAME_SUBTITLE2 = "Date";
       // public static final String COLUMN_NAME_SUBTITLE3 = "Hours";
    }
}
