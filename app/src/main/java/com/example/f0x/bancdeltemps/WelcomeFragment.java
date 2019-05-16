package com.example.f0x.bancdeltemps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.f0x.bancdeltemps.MainActivity.GLOBAL_User;

public class WelcomeFragment extends Fragment {

    private TextView tvWelcome;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        tvWelcome = (TextView) v.findViewById(R.id.tvWelcome);

        tvWelcome.setText("Benvingut/da " + GLOBAL_User.getName() +" "+ GLOBAL_User.getLastName());
        return v;
    }



}
