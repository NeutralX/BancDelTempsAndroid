package com.example.f0x.bancdeltemps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.Post;

public class DetallPost extends AppCompatActivity {

    public static final String EXTRA_POST = "com.f0x.banctemps.POST";
    public Post postRebut;
    public TextView datePost,locationPost,titlePost,descPost,userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall_post);

        datePost = (TextView) findViewById(R.id.textViewDetallDateText);
        locationPost = (TextView) findViewById(R.id.textViewDetallLocationText);
        titlePost = (TextView) findViewById(R.id.textViewDetallTitle);
        descPost = (TextView) findViewById(R.id.textViewDetallDesc);
        userName = (TextView) findViewById(R.id.textViewDetallName);

        postRebut = (Post) getIntent().getSerializableExtra(EXTRA_POST);

        datePost.setText(postRebut.getDateCreated());
        locationPost.setText(postRebut.getLocation());
        titlePost.setText(postRebut.getTitle());
        descPost.setText(postRebut.getDescription());
        userName.setText(postRebut.getUser().getName() + postRebut.getUser().getLastName());

    }
}
