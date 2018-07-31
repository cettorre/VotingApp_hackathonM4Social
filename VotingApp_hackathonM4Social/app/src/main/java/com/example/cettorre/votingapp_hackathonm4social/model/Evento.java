package com.example.cettorre.votingapp_hackathonm4social.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Evento implements Parcelable {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String logo;
    private TipoEvento tipoEvento;
    private List<Participante> participantes = null;
    private Boolean publicar;
    private Boolean cerrado;
    private Pregunta pregunta;
    private List<Opcione> opciones = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(Boolean publicar) {
        this.publicar = publicar;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<Opcione> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcione> opciones) {
        this.opciones = opciones;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.titulo);
        dest.writeString(this.descripcion);
        dest.writeString(this.logo);
        dest.writeParcelable(this.tipoEvento, flags);
        dest.writeTypedList(this.participantes);
        dest.writeValue(this.publicar);
        dest.writeValue(this.cerrado);
        dest.writeParcelable(this.pregunta, flags);
        dest.writeTypedList(this.opciones);
    }

    public Evento() {
    }

    protected Evento(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.titulo = in.readString();
        this.descripcion = in.readString();
        this.logo = in.readString();
        this.tipoEvento = in.readParcelable(TipoEvento.class.getClassLoader());
        this.participantes = in.createTypedArrayList(Participante.CREATOR);
        this.publicar = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.cerrado = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.pregunta = in.readParcelable(Pregunta.class.getClassLoader());
        this.opciones = in.createTypedArrayList(Opcione.CREATOR);
    }

    public static final Parcelable.Creator<Evento> CREATOR = new Parcelable.Creator<Evento>() {
        @Override
        public Evento createFromParcel(Parcel source) {
            return new Evento(source);
        }

        @Override
        public Evento[] newArray(int size) {
            return new Evento[size];
        }
    };

}