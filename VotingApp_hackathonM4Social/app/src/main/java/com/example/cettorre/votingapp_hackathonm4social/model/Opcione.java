package com.example.cettorre.votingapp_hackathonm4social.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Opcione implements Parcelable {

    private String id;
    private String descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.descripcion);
    }

    public Opcione() {
    }

    protected Opcione(Parcel in) {
        this.id = in.readString();
        this.descripcion = in.readString();
    }

    public static final Parcelable.Creator<Opcione> CREATOR = new Parcelable.Creator<Opcione>() {
        @Override
        public Opcione createFromParcel(Parcel source) {
            return new Opcione(source);
        }

        @Override
        public Opcione[] newArray(int size) {
            return new Opcione[size];
        }
    };
}
