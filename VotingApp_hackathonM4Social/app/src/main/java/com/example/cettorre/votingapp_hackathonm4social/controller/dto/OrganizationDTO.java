package com.example.cettorre.votingapp_hackathonm4social.controller.dto;

import com.example.cettorre.votingapp_hackathonm4social.model.Evento;

import java.util.List;

public class OrganizationDTO {

    String mail;
    String password;
    String nombreOrganizacion;
    List<Evento> eventosOrganization;

    public OrganizationDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public OrganizationDTO(String mail, String password, String nombreOrganizacion, List<Evento> eventosOrganization) {
        this.mail = mail;
        this.password = password;
        this.nombreOrganizacion = nombreOrganizacion;
        this.eventosOrganization = eventosOrganization;
    }

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
