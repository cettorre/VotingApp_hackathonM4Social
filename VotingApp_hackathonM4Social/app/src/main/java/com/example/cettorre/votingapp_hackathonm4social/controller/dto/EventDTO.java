package com.example.cettorre.votingapp_hackathonm4social.controller.dto;

import java.util.List;

public class EventDTO {


    private int id;
    private String titulo;
    private String descripcion;
    private String logo;
    private String entidad;
    private String tipoEvento;
    private List<String> participantes = null;
    private boolean publicar;
    private boolean cerrado;
    private List<String> preguntas = null;

}
