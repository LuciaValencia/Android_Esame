package com.example.android_esame.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.android_esame.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrarioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrarioFragment newInstance(String param1, String param2) {
        OrarioFragment fragment = new OrarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orario, container, false);


        // Inflate the layout for this fragment
        // in questa versione c'e' un errore coi comandi di Drawerlayout
        Bundle bundle = getArguments();
        OrarioFragmentArgs args = OrarioFragmentArgs.fromBundle(bundle);
        String url = args.getUrl();
        String page = args.getPage();
        View v = inflater.inflate(R.layout.fragment_html, container, false);
        WebView ww = v.findViewById(R.id.webview);
        ww.loadDataWithBaseURL(url, page, null, null, null);
        return v;
    }
}