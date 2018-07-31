package com.example.cettorre.votingapp_hackathonm4social.services;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;

import java.io.IOException;

public class MyService2 extends IntentService {

    public static final String TAG = "MyService2";
    public static final String MY_SERVICE_MESSAGE2 = "myServiceMessage2";
    public static final String MY_SERVICE_PAYLOAD2 = "myServicePayload2";
    public static final String REQUEST_PACKAGE_VOTE_RESPONSE = "requestPackageVoteResponse";


    public MyService2() {
        super("MyService2");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        RequestPackage requestPackage2 =
                intent.getParcelableExtra(REQUEST_PACKAGE_VOTE_RESPONSE);

        String response;
        try {
            response = HttpHelper.downloadFromFeed(requestPackage2);
            Log.e("responseres",response);
            Log.e("requestPackage",requestPackage2.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }catch (Exception e){
            e.printStackTrace();//in case response is null
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