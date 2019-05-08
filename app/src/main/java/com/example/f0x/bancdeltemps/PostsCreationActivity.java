package com.example.f0x.bancdeltemps;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.Pact;
import com.example.f0x.bancdeltemps.classes.Post;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
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
    MaterialBetterSpinner categoriesSpinner;
    int categoryId;
    String categorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_creation);

        Resources res = getResources();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, res.getStringArray(R.array.array_categories));
        categoriesSpinner = (MaterialBetterSpinner) findViewById(R.id.spinnerPostCreationCategories);

        etDescription = (EditText) findViewById(R.id.etPostCreationDescription);
        etlocation = (EditText) findViewById(R.id.etPostCreationLocation);
        etTitle = (EditText) findViewById(R.id.etPostCreationTitle);

        categoriesSpinner.setAdapter(arrayAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        categoriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                categorySelected = arg0.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

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

    public void createPost(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        String dateCreated = formatw.format(Calendar.getInstance().getTime());

        getIdCategory(view);

        Call<Integer> peticioCreacioPost = apiService.createPost(new Post(GLOBAL_User,dateCreated, null, etDescription.getText().toString(),etlocation.getText().toString(),etTitle.getText().toString(),GLOBAL_User.getIdUser(),categoryId,true,0));

        peticioCreacioPost.enqueue(new Callback<Integer>() {


            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    String idPost = response.body().toString();

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(getParent(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getIdCategory(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.API_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

        Call<Integer> peticioCategoryId = apiService.getCategoryId(categorySelected);

        peticioCategoryId.enqueue(new Callback<Integer>() {


            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {

                    categoryId = response.body();

                }
            }

            // Si peta la connexió a Internet.
            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(getParent(), "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
