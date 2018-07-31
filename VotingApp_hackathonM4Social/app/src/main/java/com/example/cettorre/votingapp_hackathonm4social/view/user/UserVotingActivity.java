package com.example.cettorre.votingapp_hackathonm4social.view.user;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.model.Opcione;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService2;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService6;
import com.example.cettorre.votingapp_hackathonm4social.utils.NetworkHelper;
import com.example.cettorre.votingapp_hackathonm4social.utils.RequestPackage;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserVotingActivity extends AppCompatActivity {

   private String  BASE_URL="http://localhost:8080/eventos/";
//http://localhost:8080/returnjson

    Controller controller=new Controller();
    ListView listOptions;
    Button sendVote;
    CheckedTextView textView;
    TextView tv_descripcionPregunta;
    int optionSelected;
    int pos;
    boolean networkOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_voting);
        initComponents();
        networkOk = NetworkHelper.hasNetworkAccess(this);
        Intent i=getIntent();
        pos=i.getIntExtra("pos",1);



     List<Opcione> listaDeOpciones = controller.getUser().getEventByPosition(pos).getOpciones();
     List<String> listaDePreguntas=new ArrayList<>();

        for (Opcione opcion:listaDeOpciones ) {
            listaDePreguntas.add(opcion.getDescripcion());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_single_choice,listaDePreguntas);
        listOptions.setAdapter(arrayAdapter);

       String description= controller.getUser().getEventByPosition(pos).getDescripcion();
       tv_descripcionPregunta.setText(description);

        sendVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!controller.getRespuestaDTO().isVoted()){


                for (int i = 0; i < listOptions.getCount(); i++) {
                    textView = (CheckedTextView) listOptions.getChildAt(i);
                    textView.setTextColor(Color.BLACK);
                    if (textView.isChecked()) {
                        textView.setTextColor(Color.RED);
                        Log.e("selection", String.valueOf(i));
                        optionSelected = i;
                    } else {
                        textView.setTextColor(Color.BLACK);
                    }
                }
                sendRequestToServer();
                controller.getRespuesta().setVoted(true);


            }else {
                    Toast t= Toast.makeText(UserVotingActivity.this, "YOU HAVE ALREADY VOTED, YOU CAN VOTE ONLY 1 TIME",Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });
    }


    private void sendRequestToServer() {




        if (networkOk) {
//            String URL=BASE_URL.concat(controller.getUser().getEventByPosition(pos).getId()+"/respuesta");
//            RequestPackage requestPackage = new RequestPackage();
//            requestPackage.setEndPoint("https://cettorre.github.io/eventosentidad.json");//TODO change string to URL
//            requestPackage.setParam("opcionSeleccionada",String.valueOf(optionSelected+1));
//           // requestPackage.setParam("", "");
//            requestPackage.setMethod("GET");
//            Log.e("BASE_URL",URL);
//            Log.e("requestPackage", requestPackage.getParams().toString());
//
//
//            Intent intent = new Intent(this, MyService2.class);
//            intent.putExtra(MyService2.REQUEST_PACKAGE_VOTE_RESPONSE, requestPackage);
//            startService(intent);





            JSONObject jsonObject2= new JSONObject();
            try {
                jsonObject2.put("userId", 1);//controller.getUser().getId()
                jsonObject2.put("optionSelected", optionSelected);
                Log.e("VOTING_LOG_SERV_RESP",jsonObject2.toString());
                Log.e("VOTING_LOG_SERV_RESP",String.valueOf(optionSelected));

            } catch (JSONException e) {
                e.printStackTrace();

            }
//TODO voting
            Intent intent2 = new Intent(this, MyService6.class);
            intent2.putExtra(MyService6.REQUEST_PACKAGE_VOTING, jsonObject2.toString());
            startService(intent2);

            Toast t=Toast.makeText(this,"THANK YOU FOR VOTING, YOU MADE THE HISTORY!!",Toast.LENGTH_LONG);
            t.show();


        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }



    private void initComponents() {
        listOptions=findViewById(R.id.list_options);
        sendVote=findViewById(R.id.btn_send_vote);
        tv_descripcionPregunta=findViewById(R.id.tv_vote_description);

    }
}
