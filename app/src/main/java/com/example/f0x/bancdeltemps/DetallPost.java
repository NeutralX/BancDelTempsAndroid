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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.f0x.bancdeltemps.classes.Pact;
import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;
import com.example.f0x.bancdeltemps.classes.Report;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseCrearPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.f0x.bancdeltemps.MainActivity.GLOBAL_User;

public class DetallPost extends AppCompatActivity {

    final DateFormat formatw = new SimpleDateFormat("dd-MM-yyyy");
    private static final String EXTRA_POST = "com.f0x.banctemps.POST";
    private static final String EXTRA_PROPIS = "com.f0x.banctemps.PROPIS";
    private Post postRebut;
    private TextView datePost, locationPost, titlePost, descPost, userName;
    public Button reportarButton, pactarButton;
    private boolean propis;
    private String m_Text = "";
    static String nomCognomUser;

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
        buscarUser((int) postRebut.getUserIdUser());
        userName.setText(nomCognomUser);

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
        builder.setTitle("Detalls report");
        builder.setTitle("Introdueix el motiu");


        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        input.setSingleLine(false);
        input.setLines(4);
        input.setMaxLines(5);
        builder.setView(input);

        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                enviarReport(m_Text);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void showPropostaDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aceptar proposta");
        builder.setTitle("Introdueix una descripció");


        final EditText input = new EditText(this);


        input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        input.setSingleLine(false);
        input.setLines(4);
        input.setMaxLines(5);
        builder.setView(input);

        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                enviarPost(m_Text);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void enviarReport(String descripcio){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        Report report = new Report(descripcio,false,postRebut.getIdPost(),GLOBAL_User.getIdUser(),postRebut.getUserIdUser());
        Call<ResponseCrearPost> peticioEnviarReport = apiService.sendReport(report);

        peticioEnviarReport.enqueue(new Callback<ResponseCrearPost>() {


            @Override
            public void onResponse(Call<ResponseCrearPost> call, Response<ResponseCrearPost> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    String idPost = response.body().getValue().toString();
                    if(idPost != null){
                        Toast.makeText(getBaseContext(), "Report enviat correctament", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<ResponseCrearPost> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void enviarPost(String descripcio){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        String dateCreated = formatw.format(Calendar.getInstance().getTime());

        Pact pact = new Pact(dateCreated,null,descripcio,postRebut.getTitle(),(int)postRebut.getIdPost(),GLOBAL_User.getIdUser(),(int)postRebut.getUserIdUser(),(int)postRebut.getHours());
        Call<ResponseCrearPost> peticioEnviarPact = apiService.sendPact(pact);

        peticioEnviarPact.enqueue(new Callback<ResponseCrearPost>() {


            @Override
            public void onResponse(Call<ResponseCrearPost> call, Response<ResponseCrearPost> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    String idPost = response.body().getValue().toString();
                    if(idPost != null){
                        Toast.makeText(getBaseContext(), "Proposta enviada correctament", Toast.LENGTH_SHORT).show();
                    }

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<ResponseCrearPost> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void buscarUser(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        Call<ResponseLogin> peticioLogin = apiService.userPerId(id);

        peticioLogin.enqueue(new Callback<ResponseLogin>() {

            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    nomCognomUser = response.body().getName() + " " + response.body().getLastName();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
