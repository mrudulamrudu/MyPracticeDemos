package com.practice.mypracticedemos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.practice.mypracticedemos.R;
import com.practice.mypracticedemos.utils.Constants;

public class CoordinatorLayoutListActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coordinator_main);

        registerViews();
    }

    private void registerViews() {
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        toolbar.setTitle("Coordinator Layout");
        setSupportActionBar(toolbar);

        Button btnScroll = findViewById(R.id.btnScroll);
        Button btnEnterAlways = findViewById(R.id.btnEnterAlways);
        Button btnScrollEnterAlways = findViewById(R.id.btnScrollEnterAlways);
        Button btnScrollEnterAlwaysCollapsed = findViewById(R.id.btnScrollEnterAlwaysCollapsed);
        Button btnScrollSnap = findViewById(R.id.btnScrollSnap);
        Button btnScrollExitUntilCollapse = findViewById(R.id.btnScrollExitUntilCollapse);
        Button btnScrollSnapEnterAlwaysCollapsed = findViewById(R.id.btnScrollSnapEnterAlwaysCollapsed);
        Button btnScrollEnterAlwaysEnterAlwaysCollapsed = findViewById(R.id.btnScrollEnterAlwaysEnterAlwaysCollapsed);

        btnScroll.setOnClickListener(this);
        btnEnterAlways.setOnClickListener(this);
        btnScrollEnterAlways.setOnClickListener(this);
        btnScrollEnterAlwaysCollapsed.setOnClickListener(this);
        btnScrollSnap.setOnClickListener(this);
        btnScrollExitUntilCollapse.setOnClickListener(this);
        btnScrollSnapEnterAlwaysCollapsed.setOnClickListener(this);
        btnScrollEnterAlwaysEnterAlwaysCollapsed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CoordinatorLayoutListActivity.this,
                CoordinatorLayoutActivity.class);
        String scrollFag;
        switch (v.getId()) {
            case R.id.btnScroll:
                scrollFag = "scroll";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnEnterAlways:
                scrollFag = "enterAlways";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollEnterAlways:
                scrollFag = "scroll|enterAlways";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollEnterAlwaysCollapsed:
                scrollFag = "scroll|enterAlwaysCollapsed";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollSnap:
                scrollFag = "scroll|snap";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollExitUntilCollapse:
                scrollFag = "scroll|exitUntilCollapse";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollSnapExitUntilCollapse:
                scrollFag = "scroll|snap|exitUntilCollapsed";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollSnapEnterAlwaysCollapsed:
                scrollFag = "enterAlwaysCollapsed|snap";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
            case R.id.btnScrollEnterAlwaysEnterAlwaysCollapsed:
                scrollFag = "scroll|enterAlways|enterAlwaysCollapsed";
                intent.putExtra(Constants.SCROLL_FLAGS, scrollFag);
                break;
        }
        startActivity(intent);
    }
}
