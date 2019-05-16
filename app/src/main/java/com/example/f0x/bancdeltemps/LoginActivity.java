package com.example.f0x.bancdeltemps;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    EditText editTextMail, editTextPassword;
    SharedPreferences sharedPref;
    static int Id_User;
    public static final String EXTRA_USER = "com.f0x.banctemps.USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextMail = findViewById(R.id.editTextLoginEmail);
        editTextPassword = findViewById(R.id.editTextLoginPassword);

        sharedPref = this.getSharedPreferences("prefs", MODE_PRIVATE);
        String email = sharedPref.getString("userEmail", "");
        editTextMail.setText(email);
    }


    public void doLogin(View view) {

        String email = editTextMail.getText().toString();
        String pass = editTextPassword.getText().toString();
        String passEncriptada = EncriptarContrassenya(pass, "Uptown girl");

        if (!email.isEmpty() && !pass.isEmpty()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

            Call<ResponseLogin> peticioLogin = apiService.doLogin(new User(email, passEncriptada));

            peticioLogin.enqueue(new Callback<ResponseLogin>() {

                @Override
                public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        Toast.makeText(LoginActivity.this, "Login OK " + response.body().getName(), Toast.LENGTH_SHORT).show();
                        sharedPref.edit().putString("userEmail", editTextMail.getText().toString()).apply();
                        Id_User = response.body().getIdUser();
                        User u = new User(response.body());
                        Intent main = new Intent(LoginActivity.this, MainActivity.class);
                        main.putExtra(Intent.EXTRA_USER, u);
                        startActivity(main);
                    } else {
                        Toast.makeText(LoginActivity.this, "Error en el correo o contrasenya ", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseLogin> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void goRegister(View v) {
        Intent main = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(main);
    }

    public static String EncriptarContrassenya(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }


}
