package com.example.android_esame.livedata;

import android.util.Log;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;

import com.example.android_esame.ui.CardSettings.CardFragmentPagerAdapter;
import com.example.android_esame.ui.CardSettings.CardPagerAdapter;
import com.example.android_esame.ui.CardSettings.Courses;
import com.example.android_esame.ui.CardSettings.Professor;
import com.example.android_esame.ui.CardSettings.ShadowTransformer;

public class CourseLiveData extends MutableLiveData<Courses> {

    //private CardPagerAdapter mCardPagerAdapter;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer  mCardShadowTransformer, mFragmentCardShadowTransformer;


    public void updateCourse(FragmentManager fm, ViewPager vp, CardPagerAdapter cpa, String title, Object prof) {
        Log.d("LIVEDATA (Lesson)", "updated");
        //Courses course=new Courses(title,prof);
        //postValue(course);

        if(prof.getClass()==Professor.class){cpa.addCardItem(new Courses(title,(Professor) prof));}
        else { 
            assert prof instanceof Professor[];
            cpa.addCardItem(new Courses(title,(Professor[]) prof));}




            //cpa.addCardItem(new Courses(title,(Professor) prof[0],(Professor) prof[1]));

        //int i = cpa.getCount();
        //mFragmentCardAdapter = new CardFragmentPagerAdapter(fm, 15);//getSupportFragmentManager(),
                //15);
       // mCardShadowTransformer = new ShadowTransformer(vp,cpa);//mViewPager, mCardPagerAdapter);
       // mFragmentCardShadowTransformer = new ShadowTransformer(vp, mFragmentCardAdapter);
       // vp.setAdapter(cpa);
      //  vp.setPageTransformer(false, mCardShadowTransformer);
      //  vp.setOffscreenPageLimit(3);


    }

    public void updateCourse(FragmentManager fm, ViewPager vp, CardPagerAdapter cpa, String title, Object prof, Object prof1) {
        Log.d("LIVEDATA (Lesson)", "updated");
        //Courses course=new Courses(title,prof);
        //postValue(course);

        cpa.addCardItem(new Courses(title,(Professor) prof,(Professor) prof1));


    }


}