package com.example.cettorre.votingapp_hackathonm4social.model;

import java.util.List;

public class Organization {

    String mail;
    String password;
    String nombreOrganizacion;
    List<Evento> eventosOrganization;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public List<Evento> getEventosOrganization() {
        return eventosOrganization;
    }

    public void setEventosOrganization(List<Evento> eventosOrganization) {
        this.eventosOrganization = eventosOrganization;
    }

}
