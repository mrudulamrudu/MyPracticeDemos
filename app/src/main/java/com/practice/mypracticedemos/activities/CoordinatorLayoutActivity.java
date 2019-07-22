package com.practice.mypracticedemos.activities;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.practice.mypracticedemos.R;

public class CoordinatorLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        registerViews();
    }

    private void registerViews() {
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle("Coordinator Layout");
        setSupportActionBar(toolbar);
    }
}
