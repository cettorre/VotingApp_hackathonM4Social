package com.example.cettorre.votingapp_hackathonm4social.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;
import com.google.gson.Gson;

import java.io.IOException;

public class MyService extends IntentService {

    public static final String TAG = "MyService";
    public static final String MY_SERVICE_MESSAGE = "myServiceMessage";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayload";
    public static final String REQUEST_PACKAGE = "requestPackage";


    public MyService() {
        super("MyService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        RequestPackage requestPackage =
                intent.getParcelableExtra(REQUEST_PACKAGE);


        String response;
        try {
            response = HttpHelper.downloadFromFeed(requestPackage);
            Log.e("response",response);
            Log.e("requestPackage",requestPackage.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Gson gson = new Gson();
        Evento[] eventos =gson.fromJson(response,Evento[].class);


        Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
        messageIntent.putExtra(MY_SERVICE_PAYLOAD, eventos);
        LocalBroadcastManager manager =
                LocalBroadcastManager.getInstance(getApplicationContext());
        manager.sendBroadcast(messageIntent);
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
