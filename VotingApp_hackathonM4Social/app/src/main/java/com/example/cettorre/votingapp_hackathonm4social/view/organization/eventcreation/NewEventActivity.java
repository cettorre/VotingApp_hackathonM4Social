package com.example.cettorre.votingapp_hackathonm4social.view.organization.eventcreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.R;

public class NewEventActivity extends AppCompatActivity {

    NumberPicker numberPicker;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        btnNext=findViewById(R.id.btn_new_event_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NewEventActivity.this, SetChoicesActivity.class);
                startActivity(i);
            }
        });

        numberPicker=findViewById(R.id.number_picker);
    }

}
