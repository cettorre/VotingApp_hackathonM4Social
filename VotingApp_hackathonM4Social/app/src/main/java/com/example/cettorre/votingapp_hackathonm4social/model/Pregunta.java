package com.example.cettorre.votingapp_hackathonm4social.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Pregunta implements Parcelable {
    private String descripcion;

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
        dest.writeString(this.descripcion);
    }

    public Pregunta() {
    }

    protected Pregunta(Parcel in) {
        this.descripcion = in.readString();
    }

    public static final Parcelable.Creator<Pregunta> CREATOR = new Parcelable.Creator<Pregunta>() {
        @Override
        public Pregunta createFromParcel(Parcel source) {
            return new Pregunta(source);
        }

        @Override
        public Pregunta[] newArray(int size) {
            return new Pregunta[size];
        }
    };
}