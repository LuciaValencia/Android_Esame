package com.example.android_esame.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.android_esame.R;
import com.example.android_esame.livedata.UserViewModel;

/**
 * guarda progetto LIVE: questo corrisponde a Activity2
 */
public class HomeFragment extends AppCompatActivity {


    /**NON MODIFICARE
     * Crea la schermata dell'ACTIVITY e imposta il nome dell'utente/lascia Ospite
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        UserViewModel.getDataUsername().observe(this,
                new Observer<String>() {
                    @Override
                    public void onChanged(String ite) {
                        TextView t = findViewById(R.id.text_home);
                        t.setText(ite);
                        Log.i("UserViewModel", "username IMPOSTATO");
                    }
                });
        setContentView(R.layout.fragment_home);
    }


    public void goToLessons(View view) {
        Log.d("onClick() su Lezioni", "funziona?");

        Intent goLessons=new Intent(this, LessonFragment.class);
        startActivity(goLessons);

    }

}

