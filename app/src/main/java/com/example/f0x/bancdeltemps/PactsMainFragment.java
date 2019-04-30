package com.example.f0x.bancdeltemps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class PactsMainFragment extends Fragment {
    private FragmentTabHost mTabHost;


    public PactsMainFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pactsmain, container, false);


        mTabHost = rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("acceptats").setIndicator("Acceptats"),
                PactsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("propis").setIndicator("Propis"),
                PactsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("historial").setIndicator("Historial"),
                PactsFragment.class, null);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String arg0) {
                Log.i("***Selected Tab", "Im currently in tab with index::" + mTabHost.getCurrentTab());
            }
        });
        //TODO: Fer que aixo es faci desde onStart no aqui

        return rootView;
    }


}
