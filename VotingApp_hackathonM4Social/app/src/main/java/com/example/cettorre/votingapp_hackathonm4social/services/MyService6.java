package com.example.cettorre.votingapp_hackathonm4social.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MyService6 extends IntentService {

    public static final String REQUEST_PACKAGE_VOTING = "requestPackVoting";
    Controller controller= new Controller();

    public MyService6() {
        super("MyService6");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

       String url="https://bcnvoting.herokuapp.com/greeting/returnjson";
       String json2 =intent.getStringExtra(REQUEST_PACKAGE_VOTING);

        RequestPackage requestPackage = new RequestPackage();
            requestPackage.setEndPoint(url);
            requestPackage.setParam("name","yo");
            requestPackage.setMethod("GET");



        String response=null;
        try {
           response = HttpHelper.sendJSON(url,json2);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }catch (Exception e){
            e.printStackTrace();
        }

        controller.createRespuesta(response);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}