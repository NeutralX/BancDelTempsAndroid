package com.example.f0x.bancdeltemps;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.f0x.bancdeltemps.classes.Pact;
import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseCrearPost;
import com.example.f0x.bancdeltemps.responses.ResponseGetPacts;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.net.HttpURLConnection;
import java.util.Date;
import java.util.List;

import static com.example.f0x.bancdeltemps.MainActivity.GLOBAL_User;

public class PostsCreationActivity extends AppCompatActivity {

    final DateFormat formatw = new SimpleDateFormat("dd-MM-yyyy");
    EditText etDescription,etlocation, etTitle;
    Spinner categoriesSpinner;
    int categoryId;
    String categorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_creation);

        Resources res = getResources();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, res.getStringArray(R.array.array_categories));
        categoriesSpinner = (Spinner) findViewById(R.id.spinnerPostCreationCategories);

        etDescription = (EditText) findViewById(R.id.etPostCreationDescription);
        etlocation = (EditText) findViewById(R.id.etPostCreationLocation);
        etTitle = (EditText) findViewById(R.id.etPostCreationTitle);

        categoriesSpinner.setAdapter(arrayAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPostsCreation);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void createPost(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        String dateCreated = formatw.format(Calendar.getInstance().getTime());

        getIdCategory(view);

        Call<ResponseCrearPost> peticioCreacioPost = apiService.createPost(new Post(GLOBAL_User,dateCreated, null, etDescription.getText().toString(),etlocation.getText().toString(),etTitle.getText().toString(),GLOBAL_User.getIdUser(),categoryId,true,0));

        peticioCreacioPost.enqueue(new Callback<ResponseCrearPost>() {


            @Override
            public void onResponse(Call<ResponseCrearPost> call, Response<ResponseCrearPost> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    String idPost = response.body().getValue().toString();
                    if(idPost != null){
                        finish();
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

    public void getIdCategory(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        categorySelected = categoriesSpinner.getSelectedItem().toString();
        Call<ResponseCrearPost> peticioCategoryId = apiService.getCategoryId(categorySelected);

        peticioCategoryId.enqueue(new Callback<ResponseCrearPost>() {


            @Override
            public void onResponse(Call<ResponseCrearPost> call, Response<ResponseCrearPost> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    categoryId = response.body().getValue();

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<ResponseCrearPost> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
