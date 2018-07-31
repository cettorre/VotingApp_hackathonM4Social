package com.example.cettorre.votingapp_hackathonm4social.view.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService;
import com.example.cettorre.votingapp_hackathonm4social.utils.NetworkHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;
import com.example.cettorre.votingapp_hackathonm4social.view.user.adapter.UserEventListAdapter;

public class UserHomeActivity extends AppCompatActivity {
    private static final String JSON_URL ="https://cettorre.github.io/participanteventlistroberto.json";
    private boolean networkOk;
    ListView eventListView;
    Controller controller= new Controller();
    UserEventListAdapter userEventListAdapter;

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

          Evento[] eventos = (Evento[]) intent.getParcelableArrayExtra(MyService.MY_SERVICE_PAYLOAD);

            for (int i = 0; i< eventos.length; i++) {
                controller.addEventToParticipant(eventos[i]);
            }
            userEventListAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        initComponents();

        sendRequestToServer();

        userEventListAdapter= new UserEventListAdapter(this,controller.getUser().getEventsUser());//TODO

        eventListView.setAdapter(userEventListAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(UserHomeActivity.this, UserVotingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComponents() {
        eventListView=findViewById(R.id.event_list);
        networkOk = NetworkHelper.hasNetworkAccess(this);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyService.MY_SERVICE_MESSAGE));
    }

    private void sendRequestToServer() {

        if (networkOk) {
            RequestPackage requestPackage = new RequestPackage();
            requestPackage.setEndPoint(JSON_URL);
            requestPackage.setParam("username", controller.getUser().getMail());//TODO
            requestPackage.setParam("password", controller.getUser().getPassword());//TODO
            requestPackage.setMethod("GET");//TODO
            Log.e("requestPackage", requestPackage.getParams().toString());

            Intent intent = new Intent(this, MyService.class);
            intent.putExtra(MyService.REQUEST_PACKAGE, requestPackage);
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
