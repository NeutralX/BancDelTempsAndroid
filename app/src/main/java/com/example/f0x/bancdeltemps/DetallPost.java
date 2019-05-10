package com.example.f0x.bancdeltemps;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.Post;

public class DetallPost extends AppCompatActivity {

    private static final String EXTRA_POST = "com.f0x.banctemps.POST";
    private static final String EXTRA_PROPIS = "com.f0x.banctemps.PROPIS";
    private Post postRebut;
    private TextView datePost, locationPost, titlePost, descPost, userName;
    public Button reportarButton, pactarButton;
    private boolean propis;
    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall_post);

        datePost = (TextView) findViewById(R.id.textViewDetallDateText);
        locationPost = (TextView) findViewById(R.id.textViewDetallLocationText);
        titlePost = (TextView) findViewById(R.id.textViewDetallTitle);
        descPost = (TextView) findViewById(R.id.textViewDetallDesc);
        userName = (TextView) findViewById(R.id.textViewDetallName);
        reportarButton = (Button) findViewById(R.id.buttonReportPost);
        pactarButton = findViewById(R.id.buttonProposta);

        descPost.setMovementMethod(new ScrollingMovementMethod());

        postRebut = (Post) getIntent().getSerializableExtra(EXTRA_POST);
        propis = (boolean) getIntent().getSerializableExtra(EXTRA_PROPIS);

        datePost.setText(postRebut.getDateCreated());
        locationPost.setText(postRebut.getLocation());
        titlePost.setText(postRebut.getTitle());
        descPost.setText(postRebut.getDescription());
        userName.setText(postRebut.getUser().getName() + " " + postRebut.getUser().getLastName());

        if (propis) {
            pactarButton.setVisibility(View.INVISIBLE);
            reportarButton.setVisibility(View.INVISIBLE);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void enviarEmail(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{
                postRebut.getUser().getEmail()});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Message");
        startActivity(Intent.createChooser(emailIntent, "Choose an email client from..."));
    }

    public void showReportDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Report Details");


        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        builder.setView(input);

        builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }
}
