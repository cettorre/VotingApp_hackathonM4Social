package com.example.cettorre.votingapp_hackathonm4social.view.organization.eventcreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cettorre.votingapp_hackathonm4social.R;

public class SetChoicesActivity extends AppCompatActivity {

    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_choices);
        btnNext =findViewById(R.id.btn_set_ch_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SetChoicesActivity.this,AddParticipantsActivity.class);
                startActivity(i);
            }
        });
    }
}
