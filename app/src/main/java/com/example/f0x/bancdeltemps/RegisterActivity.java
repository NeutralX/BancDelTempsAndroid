package com.example.f0x.bancdeltemps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.f0x.bancdeltemps.classes.User;
import com.example.f0x.bancdeltemps.interfaces.ApiBancTempsInterfaces;
import com.example.f0x.bancdeltemps.responses.ResponseRegister;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class RegisterActivity extends AppCompatActivity {

    final DateFormat formatw = new SimpleDateFormat("dd-MM-yyyy");
    Date dateOfBirthDATE;


    EditText mEditTextName;
    EditText mEditTextLastName;
    EditText mEditTextEmail;
    EditText mEditTextPassword;
    Spinner mSpinnerRegister;
    CalendarView mCalendarViewRegistre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEditTextName = findViewById(R.id.editTextRegisterName);
        mEditTextLastName = findViewById(R.id.editTextRegisterLastName);
        mEditTextEmail = findViewById(R.id.editTextRegisterEmail);
        mEditTextPassword = findViewById(R.id.editTextRegisterPassword);
        mSpinnerRegister = findViewById(R.id.spinnerRegister);
        mCalendarViewRegistre = findViewById(R.id.calendarViewRegister);
//        Calendar c = Calendar.getInstance();
//        String fullDate = formatw.format(c.getTime());
//        dateOfBirth = fullDate.substring(0, 10);

        mCalendarViewRegistre.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                try {
                    String provDate = (month + "-" + dayOfMonth + "-" + year);
                    dateOfBirthDATE = formatw.parse(provDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public void doRegister(View view) {
        Calendar c2 = Calendar.getInstance();
        String fullDate = formatw.format(c2.getTime());

        String name = mEditTextName.getText().toString();
        String lastName = mEditTextLastName.getText().toString();
        String email = mEditTextEmail.getText().toString();
        String pass = mEditTextPassword.getText().toString();
        String gender = mSpinnerRegister.getSelectedItem().toString();
        String registerDate = fullDate.substring(0, 10);
        String birthDate = formatw.format(dateOfBirthDATE);

        boolean empty = (!name.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !pass.isEmpty()
                && !gender.isEmpty() && !registerDate.isEmpty());

        if (empty) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.API_baseurl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiBancTempsInterfaces apiService = retrofit.create(ApiBancTempsInterfaces.class);

            Call<ResponseRegister> peticioLogin = apiService.doRegistre(new User(name, lastName, email, registerDate,
                    0, pass, birthDate, gender, "path"));

            peticioLogin.enqueue(new Callback<ResponseRegister>() {

                @Override
                public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                    if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                        Toast.makeText(RegisterActivity.this, "Registre completat", Toast.LENGTH_SHORT).show();
                        Intent main = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(main);
                    } else {
                        Toast.makeText(RegisterActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseRegister> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Problema amb la connexió.", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void goLogin(View view) {
        Intent main = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(main);
    }
}
