package com.example.android_esame.livedata;

import android.app.Application;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.android_esame.ui.CardSettings.CardPagerAdapter;
import com.example.android_esame.ui.CardSettings.Professor;

/**guarda progetto LIVE: questo corrisponde a MyApplication*/
public class UserViewModel extends Application {

    private static UsernameLiveData dataUsername = new UsernameLiveData();
    private static CourseLiveData dataCourse = new CourseLiveData();
    private String username, title;
    private Professor prof;
    private FragmentManager fm;
    private ViewPager vp;
    private CardPagerAdapter cpa;




    /**-----------------* DA QUI NON MOFIFICARE NULLA *----------------------*/
    void setUsername(String username) {
        this.username = username;
        dataUsername.updateName(this.username);
    }

    String getUsername() {
        return username;
    }

    public static UsernameLiveData getDataUsername(){return dataUsername;}

    public void setData(UsernameLiveData semData) {
        dataUsername = semData;
    }

    /**--------------* FINO A QUI NON MOFIFICARE NULLA *---------------------*/

    void setCourse(FragmentManager fm, ViewPager vp,CardPagerAdapter cpa, String title, Professor prof){
        this.title=title;
        this.prof=prof;
        this.cpa=cpa;
        this.fm=fm;
        this.vp=vp;
        dataCourse.updateCourse(this.fm, this.vp,this.cpa,this.title,this.prof);
    }

    public static CourseLiveData getDataCourse(){return dataCourse;}



}
