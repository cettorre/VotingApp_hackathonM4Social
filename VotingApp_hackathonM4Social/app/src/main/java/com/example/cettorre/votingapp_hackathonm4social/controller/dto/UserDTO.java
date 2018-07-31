package com.example.cettorre.votingapp_hackathonm4social.controller.dto;

import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    String mail;
    String password;
    String nombreParticipante;
    String apellidoParticipante;
    List<Evento> eventosParticipante=new ArrayList<>();

    public UserDTO(User user) {
        this.mail = user.getMail();
        this.password = user.getPassword();
        this.nombreParticipante = user.getUserName();
        this.apellidoParticipante = user.getUserLastName();
        this.eventosParticipante = user.getEventsUser();
    }
}
