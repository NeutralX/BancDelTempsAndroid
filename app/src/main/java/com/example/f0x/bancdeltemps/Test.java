package com.example.f0x.bancdeltemps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Test extends Fragment {
    private FragmentTabHost mTabHost;


    public Test() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("Fragment B"),
                PactsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("Fragment C"),
                PactsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentd").setIndicator("Fragment D"),
                PactsFragment.class, null);


        return rootView;
    }


}
