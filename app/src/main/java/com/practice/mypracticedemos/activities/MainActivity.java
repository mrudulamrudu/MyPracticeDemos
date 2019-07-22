package com.practice.mypracticedemos.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.practice.mypracticedemos.R;
import com.practice.mypracticedemos.adapters.HomeListAdapter;
import com.practice.mypracticedemos.models.Title;
import com.practice.mypracticedemos.utils.DataUtils;
import com.practice.mypracticedemos.utils.NavigationCodes;
import com.practice.mypracticedemos.utils.SpacesItemDecoration;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerViews();
    }

    private void registerViews() {

        RecyclerView recyclerViewMain = findViewById(R.id.recyclerViewMain);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataUtils.showSnackBar(view,
                        "This is multiline snackbar text.This is multiline " +
                                "snackbar text.This is multiline snackbar text.", "Action");
            }
        });

        ArrayList<Title> listTitles = new ArrayList<>();
        populateList(listTitles);
        HomeListAdapter homeListAdapter = new HomeListAdapter(this, listTitles);
        recyclerViewMain.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewMain.addItemDecoration(new SpacesItemDecoration(getResources().
                getDimensionPixelOffset(R.dimen.margin_mini)));
        recyclerViewMain.setAdapter(homeListAdapter);
    }

    private void populateList(ArrayList<Title> listTitles) {
        listTitles.add(new Title("Notifications", NavigationCodes.SCREEN_NOTIFICATIONS));
        listTitles.add(new Title("Coordinator Layout", NavigationCodes.SCREEN_COORDINATOR));
        listTitles.add(new Title("Localization", NavigationCodes.SCREEN_LOCALIZATION));
        listTitles.add(new Title("Constraint Layout", NavigationCodes.SCREEN_CONSTRAINT));
        listTitles.add(new Title("Recyclerview", NavigationCodes.SCREEN_RECYCLERVIEW));
        listTitles.add(new Title("EXO Player", NavigationCodes.SCREEN_RECYCLERVIEW));
    }
}
