package com.example.android_esame.ui.CardSettings;


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

        if(!piuProf){
            return cardP.readProf();
        }
        else if (piuProf){
            Professor[] piuProfArray=new Professor[2];
            piuProfArray[0]=cardP.readProf();
            piuProfArray[1]= cardP2.readProf();

            return piuProfArray;
        }
        return null;
    }

    public String getCardProfessorsToString() {
        if (!piuProf){
        return cardP.readProfToString();
        }
        else if(piuProf) {
            return cardP.readProfToString()+" e "+cardP2.readProfToString();
        }
        return null;
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