package com.example.cettorre.votingapp_hackathonm4social.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cettorre.votingapp_hackathonm4social.R;

public class UserHomeActivity extends AppCompatActivity {


    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
    imageButton=findViewById(R.id.img_btn_vote);

    imageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(UserHomeActivity.this,UserVotingActivity.class);
            startActivity(i);
        }
    });

    }
}
