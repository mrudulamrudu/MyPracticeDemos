package com.practice.mypracticedemos.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.practice.mypracticedemos.R;

import java.util.Locale;

public class LocalizationActivity extends BaseActivity {

    private boolean isItalianSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localization);

        registerViews();
    }

    private void registerViews() {

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setToolBar(toolbar, getString(R.string.localization));

        Button btnChangeLocale = findViewById(R.id.btnChangeLocale);
        btnChangeLocale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocale();
            }
        });
    }

    private void changeLocale() {
        Locale locale = new Locale(isItalianSelected ? "en" : "it");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        isItalianSelected = !isItalianSelected;
    }
}
