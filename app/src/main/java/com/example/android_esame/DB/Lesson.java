package com.example.android_esame.DB;

import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.ui.CardSettings.Courses;
import com.example.android_esame.ui.CardSettings.Professor;

import java.util.ArrayList;

public class Lesson {
    public Professor prof, prof2;
    public Courses course;
    //public DatePicker;
    public UserViewModel model;
    public boolean piuProf=true;
    //protected ArrayList<Professor> profArray = new ArrayList();
    protected Professor[] profArray;

    protected Courses[] courseArray;
    protected ArrayList<Lesson> lessonArray = new ArrayList();

    public void setArrayProf(){
    profArray=new Professor[10];

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

    profArray[0]=goy;

    /*profArray.add(1, goy);
    profArray.add(2, segnan);
    profArray.add(3, rapp);
    profArray.add(4, console);
    profArray.add(5, cogo);
    profArray.add(6, patrucco);
    profArray.add(7, gena);
    profArray.add(8, cena);
    profArray.add(9, tipaldo);
    profArray.add(10, vernero);
    */
}

    /*public ArrayList<Professor> getProfArray() {
        return profArray;
    }
     */

    public void setArrayCourses(){
    //this.getProfArray();
    courseArray=new Courses[10];
    //corsi: da inserire poi in un DB
    /*Courses c1 = new Courses("Programmazione Web: approcci avanzati", profArray.get(1));
    Courses c2 = new Courses("Programmazione mobile: Android", profArray.get(2));
    Courses c3 = new Courses("Intelligenza Artificiale", profArray.get(4), profArray.get(3));
    Courses c4 = new Courses("Laboratorio nuove tendenze delle ICT", profArray.get(1));
    Courses c5 = new Courses("Interazione Uomo-Macchina: approcci avanzati", profArray.get(7));
    Courses c6 = new Courses("Programmazione avanzata: Python e Arduino", profArray.get(4), profArray.get(2));
    Courses c7 = new Courses("Diritto delle ICT e dei media", profArray.get(5));
    Courses c8 = new Courses("Economia di Internet", profArray.get(6));
    Courses c9 = new Courses("Metodi digitali per la ricerca sociale", profArray.get(9));
    Courses c10 = new Courses("Web of Open and Secure Data", profArray.get(8), profArray.get(10));*/

    Courses c1 = new Courses("Programmazione Web: approcci avanzati", profArray[0]);

    courseArray[0]=c1;

    /*courseArray.add(1, c1);
    courseArray.add(2, c2);
    courseArray.add(3, c3);
    courseArray.add(4, c4);
    courseArray.add(5, c5);
    courseArray.add(6, c6);
    courseArray.add(7, c7);
    courseArray.add(8, c8);
    courseArray.add(9, c9);
    courseArray.add(10, c10);*/
}

    /*public ArrayList<Courses> getCourseArray() {
        return courseArray;
    }*/

    public Lesson (UserViewModel model, Courses course, Professor prof){
        this.model=model;
        this.course=course;
        this.prof=prof;

        this.piuProf=false;
    }

    public Lesson (UserViewModel model, Courses course, Professor prof, Professor prof2){
        this.model=model;
        this.course=course;
        this.prof=prof;
        this.prof2=prof2;

        this.piuProf=true;
    }

    public ArrayList<Lesson> setLessonArrayGeneral(){
        ArrayList<Lesson> arrayLez = new ArrayList();
        for (int i = 0; i < 100; i++){
            Lesson lez = new Lesson(model, course, prof);
            arrayLez.set(i, lez);
        }
        return arrayLez;
    }

    public Lesson[] setLessonArrayForCourse(Courses corso){
        Lesson[] arrayLez = new Lesson[10];
        for (int i=0; i<courseArray.length;i++){
            if(courseArray[i] == corso){
                Lesson lez= new Lesson(model, corso, prof);
                arrayLez[i]=lez;
            }
        }
        return arrayLez;
    }


    public ArrayList<Lesson> setLessonArrayForProf(Professor prof){
        ArrayList<Lesson> arrayLez = new ArrayList();
        for (int i=0; i<courseArray.length;i++){
            if(courseArray[i].getCourseProfessors()==prof){
                Lesson lez= new Lesson(model, courseArray[i], prof);
                arrayLez.set(i,lez);
            }
        }
        return arrayLez;
    }

}
