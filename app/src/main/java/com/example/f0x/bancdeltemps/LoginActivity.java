package com.example.f0x.bancdeltemps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;

public class LoginActivity extends AppCompatActivity {

    EditText editTextMail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextMail = findViewById(R.id.editTextLoginEmail);
        editTextPassword = findViewById(R.id.editTextLoginPassword);

    }


    public void doLogin(View view) {

        String email = editTextMail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if (!email.isEmpty() && !pass.isEmpty()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

            Call<ResponseLogin> peticioLogin = apiService.doLogin(new User(email, pass));

            peticioLogin.enqueue(new Callback<ResponseLogin>() {

                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.code()== HttpURLConnection.HTTP_OK && response.body() != null){
                        Toast.makeText(LoginActivity.this, "Login OK "+response.body().getName(), Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong user/password ", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });

        } else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void goRegister(View v){
        Intent main = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(main);
    }


}
