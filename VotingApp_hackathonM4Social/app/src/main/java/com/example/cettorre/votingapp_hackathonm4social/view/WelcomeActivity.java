package com.example.cettorre.votingapp_hackathonm4social.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.view.organization.LoginOrganizationActivity;
import com.example.cettorre.votingapp_hackathonm4social.view.organization.OrganizationHomeActivity;
import com.example.cettorre.votingapp_hackathonm4social.view.user.LoginUserActivity;
import com.example.cettorre.votingapp_hackathonm4social.view.user.UserHomeActivity;

public class WelcomeActivity extends AppCompatActivity {

    Button enterAsOrganization;
    Button enterAsUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAsOrganization=findViewById(R.id.organization_buttom);
        enterAsUser=findViewById(R.id.user_button);

        enterAsOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this,LoginOrganizationActivity.class);
                startActivity(i);
            }
        });

        enterAsUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this,LoginUserActivity.class);
                startActivity(i);
            }
        });
    }
}
