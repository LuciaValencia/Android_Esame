package com.example.android_esame.ui.CardSettings;


import java.util.ArrayList;

public class Courses {


   // private String cardProfessor;
    private Professor cardP, cardP2;
    private String cardCourse;
    private int idCard;
    boolean piuProf =true;

    private String dataSingola;
    private String oraInizio;
    private String oraFine;
    private ArrayList<String> dateMultiple=new ArrayList();


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
        /*String t="";
        if(piuProf) {
            t= cardP.readProfToString()+" e " + cardP2.readProfToString();
            Log.e("getCardProfessorsToString()", t+cardP2.readProfToString());
        }else if (!piuProf){t = cardP.readProfToString();}
        return t;
         */
        String t="";
        t=cardP.readProfToString();
        return t;
    }

    public Professor getProfessors() {
        return cardP;
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

    public void setOrario(String giornoDellaSettimana, int hI, int mI, int hF, int mF) {
        this.dataSingola=giornoDellaSettimana;
        this.oraInizio=hI+":"+mI;
        this.oraFine=hF+":"+mF;
        dateMultiple.add(dataSingola+" dalle "+oraInizio+"0 alle "+oraFine+"0");
    }

    public ArrayList<String> getOrario() {
        return this.dateMultiple;
    }
}