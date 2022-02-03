package com.example.android_esame;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.android_esame.databinding.FragmentSignupBinding;

public class SigupFragment extends Fragment {
    String url;
    FragmentSignupBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSignupBinding.inflate(inflater, container, false);

        Log.d("SignupFragment: ","crea la pagina");
        Bundle bundle=getArguments();
        url=bundle.getString("url");


        return binding.getRoot();

    }


    //in modo da poter modificare la pagina una volta che questa viene creata
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView wv = binding.webview;

        wv.loadUrl(url);
    }



}
