package com.example.cettorre.votingapp_hackathonm4social.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;

import java.io.IOException;

public class MyService5 extends IntentService {

    public static final String REQUEST_PACKAGE_LOGIN = "requestPackLogin";
    public static final String MY_SERVICE_MESSAGE = "myServiceMessagePackLogin";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayloadPackLogin";

    public MyService5() {
        super("MyService5");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String url="https://itacademybcn.herokuapp.com/hackaton/login";

        String json =intent.getStringExtra(REQUEST_PACKAGE_LOGIN);

        String response=null;
        try {
            response = HttpHelper.sendJSON(url,json);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }catch (Exception e){
            e.printStackTrace();
        }

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
