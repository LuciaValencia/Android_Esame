package com.example.android_esame.DB;

import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.ui.CardSettings.Courses;
import com.example.android_esame.ui.CardSettings.Professor;

import java.util.ArrayList;
import java.util.Date;

public class Lesson {
    public Professor prof, prof2;
    public Courses course;
    public Date date;
    public UserViewModel model;
    public boolean piuProf = true;
    //protected ArrayList<Professor> profArray = new ArrayList();
    protected Professor[] profArray;

    protected Courses[] courseArray;
    protected ArrayList<Lesson> lessonArray = new ArrayList();

    private void setArrayProf() {
        profArray = new Professor[11];

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

        profArray[0] = goy;
        profArray[1] = segnan;
        profArray[2] = rapp;
        profArray[3] = console;
        profArray[4] = cogo;
        profArray[5] = patrucco;
        profArray[6] = gena;
        profArray[7] = cena;
        profArray[8] = tipaldo;
        profArray[9] = vernero;
    }

    public Professor[] getProfArray() {
        setArrayProf();
        return profArray;
    }

    public void setArrayCourses() {
        this.getProfArray();
        courseArray = new Courses[10];

        Courses c1 = new Courses("Programmazione Web: approcci avanzati", profArray[0]);
        c1.setOrario("Lunedì",14,00,16,00);
        c1.setOrario("Mercoledì",14,00,16,00);

        Courses c2 = new Courses("Programmazione mobile: Android", profArray[1]);
        c2.setOrario("Martedì",16,00,18,00);
        c2.setOrario("Mercoledì",16,00,18,00);

        Courses c3 = new Courses("Intelligenza Artificiale", profArray[3]);//, profArray[2]);
        c3.setOrario("Lunedì",16,00,18,00);
        c3.setOrario("Giovedì",16,00,18,00);
        c3.setOrario("Venerdì",16,00,18,00);

        Courses c4 = new Courses("Laboratorio nuove tendenze delle ICT", profArray[0]);
        c4.setOrario("Lunedì",14,00,16,00);
        c4.setOrario("Martedì",16,00,18,00);

        Courses c5 = new Courses("Interazione Uomo-Macchina: approcci avanzati", profArray[6]);
        c5.setOrario("Martedì",14,00,16,00);
        c5.setOrario("Mercoledì",15,00,17,00);
        c5.setOrario("Giovedì",14,00,16,00);

        Courses c6 = new Courses("Programmazione avanzata: Python e Arduino", profArray[3]);//, profArray[1]);
        c6.setOrario("Lunedì",14,00,16,00);

        Courses c7 = new Courses("Diritto delle ICT e dei media", profArray[4]);
        c7.setOrario("Giovedì",15,00,17,00);
        c7.setOrario("Venerdì",15,00,17,00);

        Courses c8 = new Courses("Economia di Internet", profArray[5]);
        c8.setOrario("Martedì",14,00,16,00);
        c8.setOrario("Mercoledì",16,00,18,00);

        Courses c9 = new Courses("Metodi digitali per la ricerca sociale", profArray[8]);
        c9.setOrario("Martedì",14,00,16,00);
        c9.setOrario("Mercoledì",15,00,17,00);
        c9.setOrario("Giovedì",14,00,16,00);

        Courses c10 = new Courses("Web of Open and Secure Data", profArray[7]);//, profArray[9]);
        c10.setOrario("Giovedì",10,00,12,00);
        c10.setOrario("Venerdì",10,00,12,00);


        courseArray[0] = c1;
        courseArray[1] = c2;
        courseArray[2] = c3;
        courseArray[3] = c4;
        courseArray[4] = c5;
        courseArray[5] = c6;
        courseArray[6] = c7;
        courseArray[7] = c8;
        courseArray[8] = c9;
        courseArray[9] = c10;

    }

    public Courses[] getCourseArray() {
        setArrayCourses();
        return courseArray;
    }

    public String getProfessorToString() {
        setArrayCourses();
        String t="";
        for(int i=0;i<courseArray.length;i++){
            t=this.courseArray[i].getCardProfessorsToString();
        }
        return t;
    }

    public Lesson(UserViewModel model/*, Courses course, Professor prof*/) {
        this.model = model;
        // this.course=course;
        //this.prof=prof;

        // this.piuProf=false;
    }

    /*public Lesson (UserViewModel model, Courses course, Professor prof, Professor prof2){
        this.model=model;
        this.course=course;
        this.prof=prof;
        this.prof2=prof2;

        this.piuProf=true;
    }

     */

    public ArrayList<Lesson> setLessonArrayGeneral() {
        ArrayList<Lesson> arrayLez = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Lesson lez = new Lesson(model);//, course, prof);
            arrayLez.set(i, lez);
        }
        return arrayLez;
    }

    public Lesson[] setLessonArrayForCourse(Courses corso) {
        Lesson[] arrayLez = new Lesson[10];
        for (int i = 0; i < courseArray.length; i++) {
            if (courseArray[i] == corso) {
                Lesson lez = new Lesson(model);//, corso, prof);
                arrayLez[i] = lez;
            }
        }
        return arrayLez;
    }


    public ArrayList<Lesson> setLessonArrayForProf(Professor prof) {
        ArrayList<Lesson> arrayLez = new ArrayList();
        for (int i = 0; i < courseArray.length; i++) {
            if (courseArray[i].getCourseProfessors() == prof) {
                Lesson lez = new Lesson(model);//, courseArray[i], prof);
                arrayLez.set(i, lez);
            }
        }
        return arrayLez;
    }





}
