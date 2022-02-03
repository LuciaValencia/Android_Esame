package com.example.android_esame.ui.CardSettings;

public class Professor {
    private String name;
    private String surname;

    public Professor(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    public  Professor(Professor prof1, Professor prof2){
        String p1= prof1.name + " "+prof1.surname;
        String p2= "e "+prof2.name+" "+prof2.surname;
        this.name=p1;
        this.surname=p2;
    }

    public Professor readProf(){
        String profName=this.getName();
        String profSurname= this.getSurname();

        Professor prof = new Professor(profName, profSurname);

        return prof;

    }

    public String readProfToString(){

        String profName=this.getName();
        String profSurname= this.getSurname();

        return profName+" "+profSurname;

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}