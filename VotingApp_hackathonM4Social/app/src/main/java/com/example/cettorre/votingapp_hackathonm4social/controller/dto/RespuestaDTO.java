package com.example.cettorre.votingapp_hackathonm4social.controller.dto;

import com.example.cettorre.votingapp_hackathonm4social.model.Respuesta;

public class RespuestaDTO {

    boolean isVoted;

    private int option0;
    private int option1;
    private int option2;
    private int option3;
    private int option4;
    private int option5;
    private int option6;
    private int option7;
    private int option8;
    private int option9;
    private int option10;

    public RespuestaDTO(){

    }


    public RespuestaDTO(Respuesta respuesta) {
        this.isVoted = respuesta.isVoted();
        this.option0 = respuesta.getOption0();
        this.option1 = respuesta.getOption1();
        this.option2 = respuesta.getOption2();
        this.option3 = respuesta.getOption3();
        this.option4 = respuesta.getOption4();
        this.option5 = respuesta.getOption5();
        this.option6 = respuesta.getOption6();
        this.option7 = respuesta.getOption7();
        this.option8 = respuesta.getOption8();
        this.option9 = respuesta.getOption9();
        this.option10 = respuesta.getOption10();
    }

    public boolean isVoted() {
        return isVoted;
    }

    public int getOption0() {
        return option0;
    }

    public int getOption1() {
        return option1;
    }

    public int getOption2() {
        return option2;
    }

    public int getOption3() {
        return option3;
    }

    public int getOption4() {
        return option4;
    }

    public int getOption5() {
        return option5;
    }

    public int getOption6() {
        return option6;
    }

    public int getOption7() {
        return option7;
    }

    public int getOption8() {
        return option8;
    }

    public int getOption9() {
        return option9;
    }

    public int getOption10() {
        return option10;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }
}
