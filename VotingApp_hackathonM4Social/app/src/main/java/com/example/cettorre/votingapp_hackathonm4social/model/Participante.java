package com.example.cettorre.votingapp_hackathonm4social.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Participante implements Parcelable {

    private String id;
    private String email;
    private String nombre;
    private String lastName;
    private String votosAsig;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVotosAsig() {
        return votosAsig;
    }

    public void setVotosAsig(String votosAsig) {
        this.votosAsig = votosAsig;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.email);
        dest.writeString(this.nombre);
        dest.writeString(this.lastName);
        dest.writeString(this.votosAsig);
    }

    public Participante() {
    }

    protected Participante(Parcel in) {
        this.id = in.readString();
        this.email = in.readString();
        this.nombre = in.readString();
        this.lastName = in.readString();
        this.votosAsig = in.readString();
    }

    public static final Parcelable.Creator<Participante> CREATOR = new Parcelable.Creator<Participante>() {
        @Override
        public Participante createFromParcel(Parcel source) {
            return new Participante(source);
        }

        @Override
        public Participante[] newArray(int size) {
            return new Participante[size];
        }
    };
}
