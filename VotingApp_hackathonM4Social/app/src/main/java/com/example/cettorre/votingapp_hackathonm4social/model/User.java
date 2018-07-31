package com.example.cettorre.votingapp_hackathonm4social.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    String id;
    String mail;
    String password;
    String userName;
    String userLastName;
    static List<Evento> userEvents =new ArrayList<>();

    public User(){
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static List<Evento> getUserEvents() {
        return userEvents;
    }

    public static void setUserEvents(List<Evento> userEvents) {
        User.userEvents = userEvents;
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

    public List<Evento> getEventsUser() {
        return userEvents;
    }

    public void setEventsUser(List<Evento> eventosParticipante) {
        this.userEvents = eventosParticipante;
    }

    public void addEventToUser(Evento evento){
        userEvents.add(evento);

    }

    public Evento getCurrentEvent() {
        return getEventsUser().get(userEvents.size()-1);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void clearEventList(){
        userEvents.clear();
    }
         public Evento getEventByPosition(int pos){
       return userEvents.get(pos);
   }
}
