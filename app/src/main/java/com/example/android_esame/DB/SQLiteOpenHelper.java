package com.example.android_esame.DB;

public class SQLiteOpenHelper {
    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Contract.Entry.TABLE_NAME + " (" +
                    Contract.Entry._ID + " INTEGER PRIMARY KEY," +
                    Contract.Entry.COLUMN_NAME_TITLE + " TEXT," +
                    Contract.Entry.COLUMN_NAME_SUBTITLE + " TEXT)";

    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Contract.Entry.TABLE_NAME;
}
