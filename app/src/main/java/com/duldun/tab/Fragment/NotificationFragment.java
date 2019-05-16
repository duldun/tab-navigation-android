package com.duldun.tab.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.duldun.tab.Interface.ViewNotification;
import com.duldun.tab.R;


public class NotificationFragment extends Fragment {
    View rootView;
    ViewNotification viewNotification;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        //do what ever

        TextView text = rootView.findViewById(R.id.noti_text);
        text.setText(getContext().getResources().getString(R.string.notification));

        Button btn = rootView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewNotification.showNotification();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            viewNotification  = (ViewNotification) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must override OnMessageRead");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
