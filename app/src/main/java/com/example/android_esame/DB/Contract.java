package com.example.android_esame.DB;

import android.provider.BaseColumns;

public final class Contract {

    // To prevent someone from accidentally instantiating the contract class, make the constructor private.
    private Contract() {
    }

    /* Inner class that defines the table contents */
    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
