package com.ntobeko.kiokoa.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ntobeko.kiokoa.R;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Credential> {

    public ListAdapter(Context context, ArrayList<Credential> userArrayList){
        super(context, R.layout.list_view,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Credential user = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }

        TextView userName = convertView.findViewById(R.id.personName);
        TextView lastMsg = convertView.findViewById(R.id.lastMessage);
        TextView time = convertView.findViewById(R.id.msgtime);

        userName.setText(user.getSiteName());
        lastMsg.setText(user.getUserName());
        time.setText(user.getPassword());

        return convertView;
    }
}