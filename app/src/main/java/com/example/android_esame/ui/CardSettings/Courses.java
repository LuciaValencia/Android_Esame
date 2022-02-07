package com.example.android_esame.ui.CardSettings;


import android.util.Log;

public class Courses {


    private String cardProfessor;
    private Professor cardP, cardP2;
    private String cardCourse;
    private int idCard;
    boolean piuProf =true;


    public Courses(String subject, Professor prof /*, int id*/) {
        cardCourse = subject;
        cardP = prof;
        piuProf = false;
    }

    public Courses(String subject, Professor prof, Professor prof2 /*, int id*/) {
        cardCourse = subject;
        cardP = prof;
        cardP2 = prof2;
        piuProf = true;
    }

    public Courses(String subject, Professor[] prof) {
        cardCourse = subject;
        cardP = prof[0];
        cardP2 = prof[1];
        piuProf = true;
    }


    public Object getCourseProfessors() {
        /*if(!piuProf){
            return cardP.readProf();
        }
        else*/
        if (piuProf){
            Professor[] piuProfArray=new Professor[2];
            piuProfArray[0]=cardP.readProf();
            piuProfArray[1]= cardP2.readProf();

            return piuProfArray;
        }
        return cardP.readProf();
    }

    public String getCardProfessorsToString() {
        String t="";
        if(piuProf) {
            t= cardP.readProfToString()+" e " + cardP2.readProfToString();
            Log.e("getCardProfessorsToString()", t+cardP2.readProfToString());
        }else if (!piuProf){t = cardP.readProfToString();}
        return t;
    }

    public String getTitleCourse() {
        return cardCourse;
    }

    public int getIdItem() {
        return idCard;
    }

    public void getCard(int id) {
        this.getCourseProfessors();
        this.getTitleCourse();
    }

}