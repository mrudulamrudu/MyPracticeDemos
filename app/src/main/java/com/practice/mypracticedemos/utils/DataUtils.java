package com.practice.mypracticedemos.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.practice.mypracticedemos.R;

public class DataUtils {

    public static void showToast(Context context, String txt) {
        if (context == null) return;
        Toast toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showSnackBar(View view, String text, String actionTxt) {
        if (view == null) return;
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        //Hack to show multiline snackbar
        View snackbarView = snackbar.getView();
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        if (textView != null) {
            textView.setMaxLines(5);
        }
        snackbar.setAction(actionTxt, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO
            }
        });
        snackbar.setActionTextColor(ContextCompat.getColor(view.getContext(),
                R.color.colorPrimaryDark));
        snackbar.show();
    }
}
