package com.example.android_esame.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;

import com.example.android_esame.R;
import com.example.android_esame.livedata.CourseLiveData;
import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.ui.CardSettings.CardFragmentPagerAdapter;
import com.example.android_esame.ui.CardSettings.CardPagerAdapter;
import com.example.android_esame.ui.CardSettings.Courses;
import com.example.android_esame.ui.CardSettings.Professor;
import com.example.android_esame.ui.CardSettings.ShadowTransformer;

public class LessonFragment extends AppCompatActivity {

    //DbHelper dbHelper = new DbHelper(this); //NON LO SOOOOOOOOO

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

    private UserViewModel model;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardPagerAdapter; //creo classe CardPagerAdapter e Courses
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer, mCardShadowTransformer;
    CalendarView calendarView;
    private CourseLiveData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserViewModel.getDataUsername().observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String ite) {
                        TextView t = findViewById(R.id.text_exams);
                        t.setText("Lezioni di " + ite);
                        Log.i("UserViewModel", "username IMPOSTATO");
                    }
                });

        UserViewModel.getDataCourse().observe(this, new Observer<Courses>() {
            @Override
            public void onChanged(Courses ite) {
                Log.d("data in sendDialogDataToActivity(): ", ite.getTitleCourse() + " " + ite.getCardProfessorsToString());
                int i = mCardPagerAdapter.getCount();
                mCardPagerAdapter.addCardItem(ite);
            }
        });

        setContentView(R.layout.fragment_lessons);

        calendarView = findViewById(R.id.calendarView2);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                TextView t = findViewById(R.id.titolo);
                i1++;
                t.setText("Lezioni del " + i2 + "/" + i1 + "/" + i);

                TextView c = findViewById(R.id.contenuto);
                String textAdded = "";


                for (int n = 0; n < mCardPagerAdapter.getCount(); n++) {
                    //int idRis = mCardPagerAdapter.getCardItemInPosition(n).getIdItem();

                    String titolo = mCardPagerAdapter.getCardItemInPosition(n).getTitleCourse();
                    String text = mCardPagerAdapter.getCardItemInPosition(n).getCardProfessorsToString();

                    textAdded += (n + 1) + ") Corso: " + titolo + " di " + text + ".\n\n";
                }
                c.setText(textAdded);
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        //card lezioni
        mCardPagerAdapter = new CardPagerAdapter();
        int i = 0;

        mCardPagerAdapter.addCardItem(c1);
        mCardPagerAdapter.addCardItem(c2);
        mCardPagerAdapter.addCardItem(c3);


        /**-------------------* NON MODIFICARE DA QUI *------------------------*/
        //parametri per definire l'adapter per le card

        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                15);

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardPagerAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);


        mViewPager.setAdapter(mCardPagerAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        /**-------------------* NON MODIFICARE FINO A QUI *------------------------*/
    }


    /**
     * DEFINITIVO
     */
    public void addLessons(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scegli il corso da aggiungere");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialogue_layout, null);

        builder.setView(customLayout);

        RadioGroup course = customLayout.findViewById(R.id.alertInputCourse);
        RadioButton rbC1 = new RadioButton(customLayout.getContext());
        RadioButton rbC2 = new RadioButton(customLayout.getContext());
        RadioButton rbC3 = new RadioButton(customLayout.getContext());
        RadioButton rbC4 = new RadioButton(customLayout.getContext());
        RadioButton rbC5 = new RadioButton(customLayout.getContext());
        RadioButton rbC6 = new RadioButton(customLayout.getContext());
        RadioButton rbC7 = new RadioButton(customLayout.getContext());

        rbC1.setText(c4.getTitleCourse());
        rbC2.setText(c5.getTitleCourse());
        rbC3.setText(c6.getTitleCourse());
        rbC4.setText(c7.getTitleCourse());
        rbC5.setText(c8.getTitleCourse());
        rbC6.setText(c9.getTitleCourse());
        rbC7.setText(c10.getTitleCourse());

        course.addView(rbC1);
        course.addView(rbC2);
        course.addView(rbC3);
        course.addView(rbC4);
        course.addView(rbC5);
        course.addView(rbC6);
        course.addView(rbC7);

        builder.setPositiveButton("Fatto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // get selected radio button from radioGroup and get the text of the course selected to be sent to th activity
                int selectedId = course.getCheckedRadioButtonId();
                RadioButton rb = course.findViewById(selectedId);
                String rb1 = rb.getText().toString();
                Object pP = null;

                if (rb1 == c4.getTitleCourse()) {
                    pP = c4.getCourseProfessors();
                } else if (rb1 == c5.getTitleCourse()) {
                    pP = c5.getCourseProfessors();
                } else if (rb1 == c6.getTitleCourse()) {
                    pP = c6.getCourseProfessors();
                } else if (rb1 == c7.getTitleCourse()) {
                    pP = c7.getCourseProfessors();
                } else if (rb1 == c8.getTitleCourse()) {
                    pP = c8.getCourseProfessors();
                } else if (rb1 == c9.getTitleCourse()) {
                    pP = c9.getCourseProfessors();
                } else if (rb1 == c10.getTitleCourse()) {
                    pP = c10.getCourseProfessors();
                }
                sendDialogDataToActivity(rb1, pP);
            }
        });

        // create and show the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }

    /**
     * DEFINITIVO
     */
    // Do something with the data coming from the AlertDialog
    private void sendDialogDataToActivity(String course, Object professor) {

        data = UserViewModel.getDataCourse();
        data.updateCourse(getSupportFragmentManager(), mViewPager, mCardPagerAdapter, course, professor);

        //aggiunge nuova card
        int i = mCardPagerAdapter.getCount();

        //parametri per definire l'adapter per le card
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                15);
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardPagerAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mCardPagerAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        Toast.makeText(this,
                "NUOVA LEZIONE AGGIUNTA!",
                Toast.LENGTH_SHORT)
                .show();
    }


    public void deleteLessons(View view) {
        /**NON FUNZIONA*/

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scegli il corso da togliere");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialogue_layout, null);
        builder.setView(customLayout);

        RadioGroup course = customLayout.findViewById(R.id.alertInputCourse);
        RadioButton rbC1 = new RadioButton(customLayout.getContext());
        RadioButton rbC2 = new RadioButton(customLayout.getContext());
        RadioButton rbC3 = new RadioButton(customLayout.getContext());
        RadioButton rbC4 = new RadioButton(customLayout.getContext());
        RadioButton rbC5 = new RadioButton(customLayout.getContext());
        RadioButton rbC6 = new RadioButton(customLayout.getContext());
        RadioButton rbC7 = new RadioButton(customLayout.getContext());
        RadioButton rbC8 = new RadioButton(customLayout.getContext());
        RadioButton rbC9 = new RadioButton(customLayout.getContext());
        RadioButton rbC10 = new RadioButton(customLayout.getContext());

        rbC1.setText(c1.getTitleCourse());
        rbC2.setText(c2.getTitleCourse());
        rbC3.setText(c3.getTitleCourse());
        rbC4.setText(c4.getTitleCourse());
        rbC5.setText(c5.getTitleCourse());
        rbC6.setText(c6.getTitleCourse());
        rbC7.setText(c7.getTitleCourse());
        rbC8.setText(c8.getTitleCourse());
        rbC9.setText(c9.getTitleCourse());
        rbC10.setText(c10.getTitleCourse());

        course.addView(rbC1);
        course.addView(rbC2);
        course.addView(rbC3);
        course.addView(rbC4);
        course.addView(rbC5);
        course.addView(rbC6);
        course.addView(rbC7);
        course.addView(rbC8);
        course.addView(rbC9);
        course.addView(rbC10);


        builder.setPositiveButton("Fatto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int selectedId = course.getCheckedRadioButtonId();
                //RadioButton rb = course.findViewById(selectedId-1);

                if (selectedId-1 <= mCardPagerAdapter.getCount()) {
                    //Courses course = mCardPagerAdapter.getCardItemInPosition(selectedId-1);
                    CardView cardView = mCardPagerAdapter.getView(selectedId-1);
                    mCardPagerAdapter.destroyItem(mViewPager,selectedId-1,cardView);
                    //mCardPagerAdapter.getCardItemInPosition(selectedId-1);
                } else{
                        if(selectedId >= 11 && selectedId <= 20){selectedId = selectedId-10; }
                        else if(selectedId >= 21 && selectedId <= 30){selectedId = selectedId-20; }
                        else if(selectedId >= 31 && selectedId <= 40){ selectedId = selectedId-30; }
                        else if(selectedId >= 41 && selectedId <= 50){ selectedId = selectedId-40; }
                        else if(selectedId >= 51 && selectedId <= 60){ selectedId = selectedId-50; }
                        else if(selectedId >= 61 && selectedId <= 70){ selectedId = selectedId-60; }
                        else if(selectedId >= 71 && selectedId <= 80){ selectedId = selectedId-70; }
                        else if(selectedId >= 81 && selectedId <= 90){ selectedId = selectedId-80; }
                        else if(selectedId >= 91 && selectedId <= 100){ selectedId = selectedId-90; }
                    CardView cardView = mCardPagerAdapter.getView(selectedId-1);
                    mCardPagerAdapter.destroyItem(mViewPager,selectedId-1,cardView);
                }
                //Log.d("deleteLessons: ", String.valueOf(selectedId)); //mCardPagerAdapter.getCount() --> Size: 4



                //return;
            }
        });


        // create and show the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();

        //int i = mCardPagerAdapter.getCount();
//        Courses i= mCardPagerAdapter.getCardItemInPosition(0);
//
//        mCardPagerAdapter.destroyItem(mViewPager, 0,(Object) i);
//
        // TextView c = findViewById(R.id.contenuto);

        // Courses pw = mCardPagerAdapter.getCardItemInPosition(0);
//
//
//        //String titolo = mCardPagerAdapter.getCardItemInPosition(i).getTitleCourse();
//       // String text = mCardPagerAdapter.getCardItemInPosition(i).getCardProf();

        //String textAdded = "Cancellata  Lezione Goy?";
        //String textAdded = "Il bottone funziona ma non ho attivato la funzione.";

        //c.setText(textAdded);

    }
}


/**
 * TO DO
 * l'aggiunta delle card deve appartenere all'UserModel per gli utenti scritti NEIN
 * rimuovere le card quando si toglie la lezione
 * ù
 */