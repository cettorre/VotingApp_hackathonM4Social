package com.example.cettorre.votingapp_hackathonm4social.view.user.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cettorre.votingapp_hackathonm4social.R;
import com.example.cettorre.votingapp_hackathonm4social.controller.Controller;
import com.example.cettorre.votingapp_hackathonm4social.model.Evento;

import java.util.List;


public class UserEventListAdapter extends ArrayAdapter<Evento> {

    private Context context;
    Controller controller=new Controller();

    public UserEventListAdapter(@NonNull Context context, List<Evento> eventos) {
        super(context, R.layout.user_events_adapter, eventos);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater =
                (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View messageView = inflater.inflate(R.layout.user_events_adapter,parent,false);

        TextView eventName = (TextView) messageView.findViewById(R.id.tv_event_name);
        TextView eventDescription = (TextView) messageView.findViewById(R.id.tv_event_description);
        eventName.setText(controller.getUser().getEventByPosition(position).getTitulo());
        eventDescription.setText(controller.getUser().getEventByPosition(position).getDescripcion());

        return messageView;
    }



}
