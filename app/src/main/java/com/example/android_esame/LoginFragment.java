package com.example.android_esame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.livedata.UsernameLiveData;
import com.example.android_esame.databinding.LoginFragmentBinding;
import com.example.android_esame.ui.home.HomeFragment;

public class LoginFragment extends Fragment {
    private LoginFragmentBinding binding;
    private UsernameLiveData data;

    EditText name, surname, passwordET;
    String username, passwordString, gotname, gotsurname;
    Button loginBt, signupBt, login_as_hostBt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        binding=LoginFragmentBinding.inflate(inflater, container, false);
        name= binding.edittext1;
        surname=binding.usersurname;
        passwordET=binding.password;
        loginBt=binding.login;
        signupBt=binding.signup;
        login_as_hostBt=binding.loginAsHost;

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * quando schiaccio su login, fa partire tutte le funzioni interne a login() + cambia Activity  [85]
                 * poi coglie i dati (vuoti in questo primo momento)
                 * e li aggiorna secondo FullLiveData
                 */

                login();

                data= UserViewModel.getDataUsername();
                data.updateName(username);
            }
        });

        login_as_hostBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * quando schiaccio su login, fa partire tutte le funzioni interne a loginAsHost() + cambia Activity  [114]
                 * non coglie nessun dato Live
                 */

                loginAsHost();
            }
        });

        signupBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringUrl="http://bpm.sidp.cineca.it/bonita/portal/resource/process/RegistrazioneProspectUNITO/3.1/content/?id=8232152581453413882&tenant=201&locale=it&autologin";

                Bundle bundle = new Bundle();
                bundle.putString("url", stringUrl);

                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_sigupFragment,bundle);
            }
        });


    }

    //cambio schermata + LiveData con i nomi dell'utente
    public void login(){
        gotname = name.getText().toString();
        gotsurname = surname.getText().toString();
        username= gotname+" "+gotsurname;
        passwordString=passwordET.getText().toString();

        Context context=getActivity().getApplicationContext();
        int duration=Toast.LENGTH_SHORT;
        String text = "";

        if(gotname.isEmpty()||gotsurname.isEmpty()||passwordString.isEmpty()){
            text="Devi inserire tutte le credenziali";
        } else {
            text="Ciao "+username+"!";
            Intent goHome = new Intent(context, HomeFragment.class);
            startActivity(goHome);
        }

        Toast.makeText(context, text, duration).show();
    }

    //devo aggiungere il cambio schermata + LiveData qui non vengono inseriti
    public void loginAsHost(){
        Context context=getActivity().getApplicationContext();
        int duration=Toast.LENGTH_SHORT;
        String text = "Stai accedendo come ospite";

        Toast.makeText(context, text, duration).show();

        Intent goHome = new Intent(getActivity().getApplicationContext(), HomeFragment.class);
        startActivity(goHome);

    }
}
