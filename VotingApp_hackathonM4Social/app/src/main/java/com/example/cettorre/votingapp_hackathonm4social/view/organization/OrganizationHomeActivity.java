package com.example.cettorre.votingapp_hackathonm4social.view.organization;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.controller.dto.EventOrgListResponseDTO;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService3;
import com.example.cettorre.votingapp_hackathonm4social.utils.NetworkHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;
import com.example.cettorre.votingapp_hackathonm4social.view.organization.eventcreation.NewEventActivity;
import com.example.cettorre.votingapp_hackathonm4social.view.user.adapter.OrgEventListAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrganizationHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String JSON_URL =
            "https://cettorre.github.io/eventosentidad.json";

    Controller controller=new Controller();
    boolean networkOk;
    ListView orgEvenList;
    TextView tvOrganizationMail;
    EventOrgListResponseDTO eventOrgListResponseDTO;
    OrgEventListAdapter orgEventListAdapter;
    List<Evento> orgEvents=new ArrayList<>();
    List<Evento> lista=new ArrayList<>();

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            eventOrgListResponseDTO = intent.getParcelableExtra(MyService3.MY_SERVICE_PAYLOAD);

            controller.getOrganization().setEventosOrganization(eventOrgListResponseDTO.getEventos());

            orgEvents=controller.getOrganization().getEventosOrganization();

            for (Evento evento:orgEvents) {
                lista.add(evento);
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_home);
        initComponents();

        tvOrganizationMail.setText(controller.getOrganization().getMail());

        sendRequestToServer();

        orgEventListAdapter = new OrgEventListAdapter(this,lista);//TODO

        orgEvenList.setAdapter(orgEventListAdapter);

        orgEvenList.setOnItemClickListener(createOrgEventList());


    }

    private AdapterView.OnItemClickListener createOrgEventList() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OrganizationHomeActivity.this,OrgEventInfoActivity.class);
                startActivity(intent);
            }
        };
    }

    private void initComponents() {

        orgEvenList=findViewById(R.id.list_event_org);
        NavigationView navigationView=findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tvOrganizationMail=headerView.findViewById(R.id.tv_organization_mail);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(OrganizationHomeActivity.this,NewEventActivity.class);
               startActivity(i);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(mBroadcastReceiver,
                        new IntentFilter(MyService3.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.organization_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.create_new_event) {
            Intent i = new Intent(OrganizationHomeActivity.this,NewEventActivity.class);
            startActivity(i);
        } else if (id == R.id.vote_size_1) {

        } else if (id == R.id.vote_size_2) {

        } else if (id == R.id.vote_size_3) {

        } else if (id == R.id.old_event_list_nav) {

        } else if (id == R.id.create_event) {
            Intent i = new Intent(OrganizationHomeActivity.this,NewEventActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void sendRequestToServer() {

        if (networkOk) {
            RequestPackage requestPackage = new RequestPackage();
            requestPackage.setEndPoint(JSON_URL);
            requestPackage.setMethod("POST");//


            Intent intent = new Intent(this, MyService3.class);
            intent.putExtra(MyService3.REQUEST_PACKAGE_ORGANIZATION, requestPackage);
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

}
