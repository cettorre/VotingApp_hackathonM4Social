package com.example.cettorre.votingapp_hackathonm4social.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.controller.dto.RespuestaDTO;
import com.example.cettorre.votingapp_hackathonm4social.services.MyService6;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class EventResultActivity extends AppCompatActivity {

    GraphView graph;
    double mostVotedOption;
    Controller controller= new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponents();

        RespuestaDTO respuestaDTO=controller.getRespuestaDTO();

        DataPoint[] dataPoints= new DataPoint[]{
                new DataPoint(0, respuestaDTO.getOption0()),
                new DataPoint(1, respuestaDTO.getOption1()),
                new DataPoint(2, respuestaDTO.getOption2()),
                new DataPoint(3, respuestaDTO.getOption3()),
                new DataPoint(4, respuestaDTO.getOption4()),
                new DataPoint(5, respuestaDTO.getOption5()),
                new DataPoint(6, respuestaDTO.getOption6()),
                new DataPoint(7, respuestaDTO.getOption7())
        };

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(dataPoints);

        setSeries(series);

        setGraph(graph,series);

        setMostVotedOption(dataPoints);

    }

    private void setMostVotedOption(DataPoint[] dataPoints) {
        for(int i=0;i<dataPoints.length;i++){
            if( dataPoints[i].getY()>mostVotedOption) mostVotedOption=dataPoints[i].getY();
        }
    }

    private void setGraph(GraphView graph, BarGraphSeries<DataPoint> series){
        graph.addSeries(series);
        graph.getViewport().setScrollable(true);
        graph.setTitle("Result of the votation");
        graph.setTitleTextSize(60);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);
    }

    public void setSeries(BarGraphSeries<DataPoint> series) {
        series.setAnimated(true);
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
        series.setValuesOnTopSize(80);
        series.setSpacing(10);
    }

    private void initComponents() {
        setContentView(R.layout.activity_event_result);
        graph = (GraphView) findViewById(R.id.graph);
    }

}
