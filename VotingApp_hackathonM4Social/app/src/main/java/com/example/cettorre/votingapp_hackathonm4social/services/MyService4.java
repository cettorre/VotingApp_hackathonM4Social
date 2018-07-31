package com.example.cettorre.votingapp_hackathonm4social.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;

import java.io.IOException;

public class MyService4 extends IntentService {

    public static final String REQUEST_PACKAGE_NEW_USER = "requestPackNewUser";
    public static final String MY_SERVICE_MESSAGE = "myServiceMessagePackNewUser";
    public static final String MY_SERVICE_PAYLOAD = "myServicePayloadPackNewUser";

    public MyService4() {
        super("MyService4");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String url="https://itacademybcn.herokuapp.com/hackaton/users";

        String json =intent.getStringExtra(REQUEST_PACKAGE_NEW_USER);

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
