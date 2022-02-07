package com.example.android_esame.DB;

import android.provider.BaseColumns;

public final class Contract {

    /*public Professor prof;
    public Courses course;
    //public DatePicker;
    public UserViewModel model;

    //professori: da inserire poi in un DB
    Professor goy = new Professor("Annamaria", "Goy");
    Professor segnan = new Professor("Marino", "Segnan");
    Professor rapp = new Professor("Amon", "Rapp");
    Professor console = new Professor("Luca", "Console");
    Professor cogo = new Professor("Enrico", "Cogo");
    Professor patrucco = new Professor("XXX", "Patrucco");
    Professor gena = new Professor("Cristina", "Gena");
    Professor cena = new Professor("Federica", "Cena");
    Professor tipaldo = new Professor("Giuseppe", "Tipaldo");
    Professor vernero = new Professor("Fabiana", "Cernero");


    //corsi: da inserire poi in un DB
    Courses c1 = new Courses("Programmazione Web: approcci avanzati", goy);
    Courses c2 = new Courses("Programmazione mobile: Android", segnan);
    Courses c3 = new Courses("Intelligenza Artificiale", console, rapp);
    Courses c4 = new Courses("Laboratorio nuove tendenze delle ICT", goy);
    Courses c5 = new Courses("Interazione Uomo-Macchina: approcci avanzati", gena);
    Courses c6 = new Courses("Programmazione avanzata: Python e Arduino", console, segnan);
    Courses c7 = new Courses("Diritto delle ICT e dei media", cogo);
    Courses c8 = new Courses("Economia di Internet", patrucco);
    Courses c9 = new Courses("Metodi digitali per la ricerca sociale", tipaldo);
    Courses c10 = new Courses("Web of Open and Secure Data", cena, vernero);
*/








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
