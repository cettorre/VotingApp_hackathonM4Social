package com.example.cettorre.votingapp_hackathonm4social.view.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService4;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService5;
import com.example.cettorre.votingapp_hackathonm4social.utils.NetworkHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginUserActivity extends AppCompatActivity {


    EditText email;
    EditText password;
    Button btnLogin;
    Button btnCreateNewUser;
    private boolean networkOk;

    Controller controller= new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.getUser().setMail(email.getText().toString());
                controller.getUser().setPassword(password.getText().toString());
                Intent i= new Intent(LoginUserActivity.this,UserHomeActivity.class);
                startActivity(i);
                sendRequestToServer();
            }
        });

        btnCreateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginUserActivity.this,NewUserActivity.class);
                startActivity(i);
            }
        });



    }


    private void sendRequestToServer() {

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("email", controller.getUser().getMail());
            jsonObject.put("password", controller.getUser().getPassword());
            Log.e("LOGIN_LOG",jsonObject.toString());
            } catch (JSONException e) {
            e.printStackTrace();
        }


        if (networkOk) {
            Log.e("JSON",jsonObject.toString());

            Intent intent = new Intent(this, MyService5.class);
            intent.putExtra(MyService5.REQUEST_PACKAGE_LOGIN, jsonObject.toString());
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initComponents() {
        networkOk = NetworkHelper.hasNetworkAccess(this);

        setContentView(R.layout.activity_login_user);
        email=findViewById(R.id.et_mail_user);
        password=findViewById(R.id.et_password_user);
        btnLogin=findViewById(R.id.btn_loginParticipant);
        btnCreateNewUser=findViewById(R.id.btn_createUser);
    }
}
