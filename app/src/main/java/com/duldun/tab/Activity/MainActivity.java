package com.duldun.tab.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.duldun.tab.Fragment.HomeFragment;
import com.duldun.tab.Fragment.NotificationFragment;
import com.duldun.tab.Fragment.OrdersFragment;
import com.duldun.tab.Fragment.ProfileFragment;
import com.duldun.tab.Interface.ViewNotification;
import com.duldun.tab.R;

public class MainActivity extends AppCompatActivity implements ViewNotification {

    RelativeLayout home,status,order,profile;
    ImageView homeIcon,orderIcon,statusIcon,profileIcon,notiBaj;
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        //layout
        home = findViewById(R.id.home);
        status = findViewById(R.id.status);
        order = findViewById(R.id.order);
        profile = findViewById(R.id.profile);

        //image view
        homeIcon = findViewById(R.id.home_icon);
        orderIcon = findViewById(R.id.order_icon);
        statusIcon = findViewById(R.id.status_icon);
        profileIcon = findViewById(R.id.profile_icon);

        notiBaj = findViewById(R.id.noti_baj);

        moveTabs();
        moveHome();
        changeHomeIcon();
    }

    private void moveTabs() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveHome();
                changeHomeIcon();
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveOrder();
                changeOrderIcon();
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveStatus();
                changeStatusIcon();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveProfile();
                changeProfileIcon();
            }
        });
    }

    private void moveProfile() {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ProfileFragment frag = new ProfileFragment();
        fragmentTransaction.replace(R.id.fragment, frag,"profile");
        fragmentTransaction.addToBackStack(null).commit();
    }

    private void MoveStatus() {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NotificationFragment frag = new NotificationFragment();
        fragmentTransaction.replace(R.id.fragment, frag,"status");
        fragmentTransaction.addToBackStack(null).commit();
    }

    private void moveOrder() {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        OrdersFragment frag = new OrdersFragment();
        fragmentTransaction.replace(R.id.fragment, frag,"order");
        fragmentTransaction.addToBackStack(null).commit();
    }

    private void moveHome() {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment frag = new HomeFragment();
        fragmentTransaction.replace(R.id.fragment, frag,"home");
        fragmentTransaction.addToBackStack(null).commit();
    }

    private void changeHomeIcon() {
        homeIcon.setImageResource(R.drawable.home_click);
        orderIcon.setImageResource(R.drawable.order);
        statusIcon.setImageResource(R.drawable.noti);
        profileIcon.setImageResource(R.drawable.profile);
    }

    private void changeOrderIcon() {
        homeIcon.setImageResource(R.drawable.home);
        orderIcon.setImageResource(R.drawable.order_click);
        statusIcon.setImageResource(R.drawable.noti);
        profileIcon.setImageResource(R.drawable.profile);
    }

    private void changeStatusIcon() {
        homeIcon.setImageResource(R.drawable.home);
        orderIcon.setImageResource(R.drawable.order);
        statusIcon.setImageResource(R.drawable.noti_click);
        profileIcon.setImageResource(R.drawable.profile);
    }

    private void changeProfileIcon() {
        homeIcon.setImageResource(R.drawable.home);
        orderIcon.setImageResource(R.drawable.order);
        statusIcon.setImageResource(R.drawable.noti);
        profileIcon.setImageResource(R.drawable.profile_click);
    }


    @Override
    public void showNotification() {
        notiBaj.setVisibility(ImageView.GONE);
    }
}
