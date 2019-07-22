package com.practice.mypracticedemos.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.practice.mypracticedemos.R;
import com.practice.mypracticedemos.activities.CoordinatorLayoutListActivity;
import com.practice.mypracticedemos.activities.LocalizationActivity;
import com.practice.mypracticedemos.activities.NotificationsActivity;
import com.practice.mypracticedemos.models.Title;
import com.practice.mypracticedemos.utils.NavigationCodes;

import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Title> listTitles;
    private TitleClickListener titleClickListener;

    public HomeListAdapter(Context context, ArrayList<Title> listTitles) {
        this.context = context;
        this.listTitles = listTitles;
        titleClickListener = new TitleClickListener();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_list_row, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainViewHolder mainViewHolder = (MainViewHolder) holder;

        Title title = listTitles.get(position);

        TextView txtTitle = mainViewHolder.getTxtTitle();
        txtTitle.setText(title.getTitle());

        txtTitle.setTag(R.id.slug, title.getSlug());
        txtTitle.setOnClickListener(titleClickListener);
    }

    @Override
    public int getItemCount() {
        return listTitles.size();
    }

    public static class TitleClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String slug = (String) v.getTag(R.id.slug);
            if (TextUtils.isEmpty(slug)) return;
            Intent intent;
            switch (slug) {
                case NavigationCodes.SCREEN_NOTIFICATIONS:
                    intent = new Intent(v.getContext(), NotificationsActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case NavigationCodes.SCREEN_LOCALIZATION:
                    intent = new Intent(v.getContext(), LocalizationActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case NavigationCodes.SCREEN_COORDINATOR:
                    intent = new Intent(v.getContext(), CoordinatorLayoutListActivity.class);
                    v.getContext().startActivity(intent);
                    break;
            }
        }
    }

    private class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView txtTitle;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        TextView getTxtTitle() {
            if (txtTitle == null) {
                txtTitle = itemView.findViewById(R.id.txtTitle);
            }
            return txtTitle;
        }
    }
}
