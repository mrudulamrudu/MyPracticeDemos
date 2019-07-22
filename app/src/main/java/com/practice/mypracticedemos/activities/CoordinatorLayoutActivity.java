package com.practice.mypracticedemos.activities;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.practice.mypracticedemos.R;
import com.practice.mypracticedemos.utils.Constants;

public class CoordinatorLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);

        String scrollFlag = getIntent().getStringExtra(Constants.SCROLL_FLAGS);
        toolbar.setTitle(scrollFlag);
        setSupportActionBar(toolbar);

        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) collapsingToolbar.getLayoutParams();

        switch (scrollFlag) {
            case "scroll":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                break;
            case "enterAlways":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                break;
            case "scroll|enterAlways":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                break;
            case "scroll|enterAlwaysCollapsed":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
                break;
            case "scroll|snap":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
                break;
            case "scroll|exitUntilCollapse":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                break;
            case "scroll|snap|exitUntilCollapsed":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
                break;
            case "enterAlwaysCollapsed|snap":
                params.setScrollFlags(
                        AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED
                                | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
                break;
            case "scroll|enterAlways|enterAlwaysCollapsed":
                params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
                        | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
                break;
        }
        collapsingToolbar.setLayoutParams(params);
    }
}
