package com.example.android_esame.DB;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_esame.R;

public class CustomAdapter extends ArrayAdapter<Lesson> {
    LayoutInflater inflater;
    int layoutResourceId;
    Lesson lezioni[];

    public CustomAdapter( Context context, int LayoutResourceId, Lesson[] lezioni) {
        super(context, LayoutResourceId, lezioni);
        this.layoutResourceId = layoutResourceId;
        this.inflater = ((Activity) context).getLayoutInflater();
        this.lezioni = lezioni;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        Lesson ob = lezioni[position];
        if (row == null) {
            // cerca i widget all'interno del singolo list item
            row = inflater.inflate(layoutResourceId, parent, false);
            ((TextView) (row.findViewById(R.id.editText1))).setText(ob.course.getTitleCourse());
            ((TextView) (row.findViewById(R.id.editText2))).setText(ob.prof.readProfToString());
            //((TextView) (row.findViewById(R.id.editText3))).setText(""+ob.eta);
        }
        Button btn = row.findViewById(R.id.add_btn);
        btn.setOnClickListener(v -> Toast.makeText(parent.getContext(), "CLICK: " + position, Toast.LENGTH_LONG).show());
        return row;
    }
}
