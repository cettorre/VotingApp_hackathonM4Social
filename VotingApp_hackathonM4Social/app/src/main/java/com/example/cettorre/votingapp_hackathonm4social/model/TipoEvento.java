package com.example.cettorre.votingapp_hackathonm4social.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TipoEvento implements Parcelable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    public TipoEvento() {
    }

    protected TipoEvento(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<TipoEvento> CREATOR = new Parcelable.Creator<TipoEvento>() {
        @Override
        public TipoEvento createFromParcel(Parcel source) {
            return new TipoEvento(source);
        }

        @Override
        public TipoEvento[] newArray(int size) {
            return new TipoEvento[size];
        }
    };
}
