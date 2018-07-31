package com.example.cettorre.votingapp_hackathonm4social.controller.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.cettorre.votingapp_hackathonm4social.model.Evento;

import java.util.List;

public class EventOrgListResponseDTO implements Parcelable {

    private String login;
    private List<Evento> eventos = null;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeTypedList(this.eventos);
    }

    public EventOrgListResponseDTO() {
    }

    protected EventOrgListResponseDTO(Parcel in) {
        this.login = in.readString();
        this.eventos = in.createTypedArrayList(Evento.CREATOR);
    }

    public static final Parcelable.Creator<EventOrgListResponseDTO> CREATOR = new Parcelable.Creator<EventOrgListResponseDTO>() {
        @Override
        public EventOrgListResponseDTO createFromParcel(Parcel source) {
            return new EventOrgListResponseDTO(source);
        }

        @Override
        public EventOrgListResponseDTO[] newArray(int size) {
            return new EventOrgListResponseDTO[size];
        }
    };

    @Override
    public String toString() {
        return "EventOrgListResponseDTO{" +
                "login='" + login + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}