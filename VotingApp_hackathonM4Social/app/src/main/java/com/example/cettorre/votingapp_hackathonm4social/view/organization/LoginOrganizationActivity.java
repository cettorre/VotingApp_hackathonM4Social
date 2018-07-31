package com.example.cettorre.votingapp_hackathonm4social.view.organization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.controller.dto.OrganizationDTO;
import com.example.cettorre.votingapp_hackathonm4social.view.user.LoginUserActivity;
import com.example.cettorre.votingapp_hackathonm4social.view.user.UserHomeActivity;

public class LoginOrganizationActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    Button btnLogin;
    Button btnCreateParticipant;
    Controller controller=new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_organization);
        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OrganizationDTO organizationDTO = new OrganizationDTO(
                        mail.getText().toString(),
                        password.getText().toString()
                );

                controller.setOrganizatioForLogIn(organizationDTO);

                Intent i= new Intent(LoginOrganizationActivity.this,OrganizationHomeActivity.class);
                startActivity(i);            }
        });
    }

    private void initComponents() {
        mail =findViewById(R.id.mail);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btn_login);
        btnCreateParticipant=findViewById(R.id.btn_createOrganization);

    }
}
