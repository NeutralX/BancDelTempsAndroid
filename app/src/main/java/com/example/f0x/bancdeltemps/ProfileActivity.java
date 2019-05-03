package com.example.f0x.bancdeltemps;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.f0x.bancdeltemps.MainActivity.GLOBAL_User;

public class ProfileActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private TextView tvName,tvEmail,tvHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvName = (TextView) findViewById(R.id.textViewProfileName);
        tvEmail = (TextView) findViewById(R.id.textViewProfileEmail);
        tvHours = (TextView) findViewById(R.id.textViewProfileHours);

        tvName.setText(GLOBAL_User.getName() + " " + GLOBAL_User.getLastName());
        tvEmail.setText(GLOBAL_User.getEmail());
        tvHours.setText("Hours: " + GLOBAL_User.getTimeHours());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Posts"));
        tabLayout.addTab(tabLayout.newTab().setText("Pacts"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
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
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
