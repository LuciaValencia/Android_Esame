package com.example.android_esame.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.android_esame.livedata.UserViewModel;
import com.example.android_esame.ui.CardSettings.CardFragmentPagerAdapter;
import com.example.android_esame.ui.CardSettings.CardPagerAdapter;
import com.example.android_esame.ui.CardSettings.ShadowTransformer;

public class ExamsFragment extends AppCompatActivity {

    private UserViewModel model;

    private ViewPager  mViewPager2;
    private CardPagerAdapter  mCardPagerAdapter2; //creo classe CardPagerAdapter e Courses
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer, mFragmentCardShadowTransformer2, mCardShadowTransformer, mCardShadowTransformer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}



