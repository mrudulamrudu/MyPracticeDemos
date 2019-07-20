package com.practice.mypracticedemos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Title implements Parcelable {

    private String title;
    private String slug;

    public Title(String title, String slug){
        this.title = title;
        this.slug = slug;
    }

    private Title(Parcel in) {
        title = in.readString();
        slug= in.readString();
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public static final Creator<Title> CREATOR = new Creator<Title>() {
        @Override
        public Title createFromParcel(Parcel in) {
            return new Title(in);
        }

        @Override
        public Title[] newArray(int size) {
            return new Title[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(slug);
    }
}
