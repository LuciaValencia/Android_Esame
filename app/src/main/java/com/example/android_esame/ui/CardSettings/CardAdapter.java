package com.example.android_esame.ui.CardSettings;

import androidx.cardview.widget.CardView;

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}


