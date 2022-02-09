package com.example.android_esame.ui.home;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
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

import com.example.android_esame.DB.Lesson;
import com.example.android_esame.R;
import com.example.android_esame.livedata.CourseLiveData;
import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.ui.CardSettings.CardFragmentPagerAdapter;
import com.example.android_esame.ui.CardSettings.CardPagerAdapter;
import com.example.android_esame.ui.CardSettings.Courses;
import com.example.android_esame.ui.CardSettings.ShadowTransformer;

import java.util.ArrayList;

public class LessonFragment extends AppCompatActivity {

    private UserViewModel model;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardPagerAdapter;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer, mCardShadowTransformer;
    CalendarView calendarView;
    private CourseLiveData data;

    public Lesson lesson = new Lesson(model);
    Courses[] corsi = lesson.getCourseArray();


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

        lesson.getProfArray();

        setContentView(R.layout.fragment_lessons);

        /**-------------------* NON MODIFICARE DA QUI *------------------------*/
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        //card lezioni
        mCardPagerAdapter = new CardPagerAdapter();
        int i = 0;

        mCardPagerAdapter.addCardItem(corsi[0]);
        mCardPagerAdapter.addCardItem(corsi[1]);
        mCardPagerAdapter.addCardItem(corsi[2]);

        //parametri per definire l'adapter per le card
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                15);

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardPagerAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardPagerAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

        /**-------------------* NON MODIFICARE FINO A QUI *------------------------*/

        calendarView = findViewById(R.id.calendarView2);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                TextView t = findViewById(R.id.titolo);
                i1++;
                t.setText("Lezioni del " + i2 + "/" + i1 + "/" + i);

                //TextView c = findViewById(R.id.contenuto);
                String textAdded = "";
                ListView listView = findViewById(R.id.list);

                ArrayList<String> arr = new ArrayList();

                for(int n=0; n <mCardPagerAdapter.getCount();n++){
                    //arr.add("Item "+ corsi[n].getTitleCourse()+"\n"); //manca: corsi del "professor"
                    textAdded=corsi[n].getTitleCourse()+"\n"; //manca: corsi del "professor"
                    arr.add(textAdded+n);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, arr);

                listView.setAdapter(adapter);

                /**TO DO : capire come risolvere la listview in base al file del prof*/

                /** da rivedere in seguito: per ora non serve
                 * listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        String itemValue = (String) listView.getItemAtPosition(position);
                        Courses item= (Courses) listView.getItemAtPosition(position);
                        itemValue=item.getTitleCourse();
                        position++;
                        Toast.makeText(LessonFragment.this,
                                "Position :" + position + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                    }

                });
                 */

                //.setText(textAdded);

            }
        });
    }


    /** DEFINITIVO */
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

                rbC1.setText(corsi[3].getTitleCourse());
                rbC2.setText(corsi[4].getTitleCourse());
                rbC3.setText(corsi[5].getTitleCourse());
                rbC4.setText(corsi[6].getTitleCourse());
                rbC5.setText(corsi[7].getTitleCourse());
                rbC6.setText(corsi[8].getTitleCourse());
                rbC7.setText(corsi[9].getTitleCourse());

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

                if (rb1 == corsi[3].getTitleCourse()) {
                    pP = corsi[3].getCourseProfessors();
                } else if (rb1 == corsi[4].getTitleCourse()) {
                    pP = corsi[4].getCourseProfessors();
                } else if (rb1 == corsi[5].getTitleCourse()) {
                    pP = corsi[5].getCourseProfessors();
                } else if (rb1 == corsi[6].getTitleCourse()) {
                    pP = corsi[6].getCourseProfessors();
                } else if (rb1 == corsi[7].getTitleCourse()) {
                    pP = corsi[7].getCourseProfessors();
                } else if (rb1 == corsi[8].getTitleCourse()) {
                    pP = corsi[8].getCourseProfessors();
                } else if (rb1 == corsi[9].getTitleCourse()) {
                    pP = corsi[9].getCourseProfessors();
                }
                sendDialogDataToActivity(rb1, pP);
            }
        });

        // create and show the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }

    /** DEFINITIVO */
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

    /** DEFINITIVO */
    public void deleteLessons(View view) {
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

                rbC1.setText(corsi[0].getTitleCourse());
                rbC2.setText(corsi[1].getTitleCourse());
                rbC3.setText(corsi[2].getTitleCourse());
                rbC4.setText(corsi[3].getTitleCourse());
                rbC5.setText(corsi[4].getTitleCourse());
                rbC6.setText(corsi[5].getTitleCourse());
                rbC7.setText(corsi[6].getTitleCourse());
                rbC8.setText(corsi[7].getTitleCourse());
                rbC9.setText(corsi[8].getTitleCourse());
                rbC10.setText(corsi[9].getTitleCourse());

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
            }
        });

        // create and show the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }
}







/**
 * TO DO
 * l'aggiunta delle card deve appartenere all'UserModel per gli utenti scritti NEIN
 */