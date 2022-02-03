package com.example.android_esame.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

/**guarda progetto LIVE: questo corrisponde a SemaphoreLiveData*/
public class UsernameLiveData extends MutableLiveData<String> {

    public void updateName(String result) {
        Log.d("LIVEDATA (Name)", "updated");
        postValue(result);
    }


}


