package com.example.android_esame.ui.home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class NOPE_ExamsDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("Vuoi confermare di registrarti al primo esame disonibile?")
                .setPositiveButton("Conferma", (dialog, which) -> {} )
                .create();
    }

    public static String TAG = "GIORNO DELL'ESAME";
}


