package com.example.cettorre.votingapp_hackathonm4social.controller;

import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.controller.dto.OrganizationDTO;
import com.example.cettorre.votingapp_hackathonm4social.controller.dto.RespuestaDTO;
import com.example.cettorre.votingapp_hackathonm4social.controller.dto.UserDTO;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.model.Organization;
import com.example.cettorre.votingapp_hackathonm4social.model.Respuesta;
import com.example.cettorre.votingapp_hackathonm4social.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    //https://cettorre.github.io/serverresponse.json
    //http://560057.youcanlearnit.net/services/json/itemsfeed.php

    private static User user =new User();
    private static Organization organization=new Organization();
    private static Respuesta respuesta= new Respuesta();
    private RespuestaDTO respuestaDTO;

    public  Respuesta getRespuesta() {
        return respuesta;
    }

    public RespuestaDTO getRespuestaDTO() {
        return respuestaDTO= new RespuestaDTO(respuesta);
    }

    public User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Controller.user = user;
    }

    public UserDTO getParticipantDTO(){
        UserDTO userDTO =new UserDTO(user);
        return userDTO;
    }


    public  Organization getOrganization() {
        return organization;
    }

    public void addEventToParticipantDTO(Evento evento){
        user.addEventToUser(evento);
    }

    private static  List<User> participantsList = new ArrayList<>();

    public static List<User> getParticipantsList() {
        return participantsList;
   }

    public static void setParticipantsList(List<User> participantsList) {
        Controller.participantsList = participantsList;
    }

    public void addEventToParticipant(Evento evento){
        user.addEventToUser(evento);
    }

    public void clearEventList(){
       user.clearEventList();
    }

    public void setOrganizatioForLogIn(OrganizationDTO organizatioForLogIn) {
        organization.setMail(organizatioForLogIn.getMail());
        organization.setPassword(organizatioForLogIn.getPassword());
        }

    public void createRespuesta(String response) {

        try {
            JSONObject jsonObject= new JSONObject(response);

            respuesta.setOption0(jsonObject.getInt("option0"));
            respuesta.setOption1(jsonObject.getInt("option1"));
            respuesta.setOption2(jsonObject.getInt("option2"));
            respuesta.setOption3(jsonObject.getInt("option3"));
            respuesta.setOption4(jsonObject.getInt("option4"));
            respuesta.setOption5(jsonObject.getInt("option5"));
            respuesta.setOption6(jsonObject.getInt("option6"));
            respuesta.setOption7(jsonObject.getInt("option7"));
            respuesta.setOption8(jsonObject.getInt("option8"));
            respuesta.setOption9(jsonObject.getInt("option9"));
            respuesta.setOption10(jsonObject.getInt("option10"));
            respuesta.setVoted(true);


            int option1=jsonObject.getInt("option1");
            Log.e("OPTION1CONTROLLER",respuesta.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}



