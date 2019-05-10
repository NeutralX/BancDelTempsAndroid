package com.example.f0x.bancdeltemps;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.Toast;

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
        //TODO: Carregar les daeds per a fer-les com al perfil
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Acceptats"));
        tabLayout.addTab(tabLayout.newTab().setText("Propis"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        mTabHost.addTab(mTabHost.newTabSpec("acceptats").setIndicator("Acceptats"),
//                PactsFragment.class, null);
//        mTabHost.addTab(mTabHost.newTabSpec("propis").setIndicator("Propis"),
//                PactsFragment.class, null);
//        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String arg0) {
//                Toast.makeText(getContext(), "Im currently in tab " + mTabHost.getCurrentTab(), Toast.LENGTH_SHORT).show();
//            }
//        });
        //TODO: Fer que aixo es faci desde onStart no aqui
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        final PagerAdapterPacts adapter = new PagerAdapterPacts
                (getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return rootView;
    }



}