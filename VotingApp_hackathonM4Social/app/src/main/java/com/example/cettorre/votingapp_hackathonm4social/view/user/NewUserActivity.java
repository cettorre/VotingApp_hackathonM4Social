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
import com.example.cettorre.votingapp_hackathonm4social.utils.NetworkHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;

import org.json.JSONException;
import org.json.JSONObject;

public class NewUserActivity extends AppCompatActivity {

    EditText etNewName;
    EditText etNewLastNames;
    EditText etNewEmail;
    EditText etNewPassword;
    Button btnCreateNewUser;
    private static final String JSON_URL ="http://192.168.0.163:8080/";
    private boolean networkOk;
    Controller controller= new Controller();
    String name;
    String lastNames;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();

        networkOk = NetworkHelper.hasNetworkAccess(this);

        btnCreateNewUser.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 name=etNewName.getText().toString();
                 lastNames=etNewLastNames.getText().toString();
                 email=etNewEmail.getText().toString();
                 password=etNewPassword.getText().toString();

                 sendRequestToServer();
             }
         });
    }

    private void sendRequestToServer() {

        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("name", name);
            jsonObject.put("lastName", lastNames);
            jsonObject.put("email", email);
            jsonObject.put("password", password);
            jsonObject.put("idProfile", 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }


      if (networkOk) {
            Intent intent = new Intent(this, MyService4.class);
            intent.putExtra(MyService4.REQUEST_PACKAGE_NEW_USER, jsonObject.toString());
            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initComponents() {
        setContentView(R.layout.activity_new_user);
        etNewName=findViewById(R.id.et_name_new_user);
        etNewLastNames=findViewById(R.id.et_lastnames_new_user);
        etNewEmail=findViewById(R.id.et_mail_new_user);
        etNewPassword=findViewById(R.id.et_password_new_user);
        btnCreateNewUser=findViewById(R.id.btn_create_new_user);
    }
}
