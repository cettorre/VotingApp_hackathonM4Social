package com.example.cettorre.votingapp_hackathonm4social.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.controller.dto.EventOrgListResponseDTO;
import com.example.cettorre.votingapp_hackathonm4social.utils.HttpHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;
import com.google.gson.Gson;

import java.io.IOException;

public class MyService3 extends IntentService{
        public static final String TAG = "MyService";
        public static final String MY_SERVICE_MESSAGE = "myServiceMessageOrganization";
        public static final String MY_SERVICE_PAYLOAD = "myServicePayloadOrganization";
        public static final String REQUEST_PACKAGE_ORGANIZATION = "requestPackOrg";

        public MyService3() {
            super("MyService3");
        }

        @Override
        protected void onHandleIntent(Intent intent) {

            RequestPackage requestPackage =
                    intent.getParcelableExtra(REQUEST_PACKAGE_ORGANIZATION);

            String response;
            try {
                response = HttpHelper.downloadFromFeed(requestPackage);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            Gson gson = new Gson();
            EventOrgListResponseDTO eventosOrganization =gson.fromJson(response,EventOrgListResponseDTO.class);

            Intent messageIntent = new Intent(MY_SERVICE_MESSAGE);
            messageIntent.putExtra(MY_SERVICE_PAYLOAD, eventosOrganization);
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
