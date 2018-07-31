package com.example.cettorre.votingapp_hackathonm4social.view.organization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;
import com.example.cettorre.votingapp_hackathonm4social.model.Participante;
import com.example.cettorre.votingapp_hackathonm4social.view.EventResultActivity;

import java.util.ArrayList;
import java.util.List;

public class OrgEventInfoActivity extends AppCompatActivity {

    Controller controller=new Controller();
    ListView listaParticipantes;
    TextView tvIDEvento;
    TextView tvTituloEvento;
    TextView tvDescripcionEvento;
    TextView tvTipoEvento;
    TextView tvPregunta;
    Button btnWatchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_event_info);
        initComponents();

        Intent i= getIntent();
        int pos=i.getIntExtra("pos",1);

       List<Participante> participantes= controller.getOrganization().getEventosOrganization().get(pos).getParticipantes();

       List<String> participantesString=new ArrayList<>();
        for (Participante participante:participantes) {
            participantesString.add(participante.getEmail());

        }

        Log.e("participantes",participantesString.toString());


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,participantesString);
        listaParticipantes.setAdapter(arrayAdapter);

        Evento evento=controller.getOrganization().getEventosOrganization().get(pos);

        tvIDEvento.setText(String.valueOf(evento.getId()));
        tvDescripcionEvento.setText(evento.getDescripcion());
        tvTituloEvento.setText(evento.getTitulo());
        tvTipoEvento.setText(evento.getTipoEvento().getName());
        tvPregunta.setText(evento.getPregunta().getDescripcion());

        btnWatchResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OrgEventInfoActivity.this, EventResultActivity.class);
                startActivity(i);
            }
        });
    }

    private void initComponents() {
        listaParticipantes=findViewById(R.id.listview_participantes_org);
        tvIDEvento=findViewById(R.id.tv_org_id_evento);
        tvTituloEvento=findViewById(R.id.tv_org_titulo_evento);
        tvDescripcionEvento=findViewById(R.id.tvDescripcionEvento);
        tvTipoEvento=findViewById(R.id.tv_tipo_evento);
        tvPregunta =findViewById(R.id.tv_org_pregunta_evento);
        btnWatchResult=findViewById(R.id.btn_watch_result);
    }
}
