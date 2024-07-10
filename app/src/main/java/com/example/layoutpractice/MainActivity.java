package com.example.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    Button btnLogin;

    TextView linkSignIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.userName);
        etPassword = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);
        linkSignIn = findViewById(R.id.btnSignIn);

        String userName, password;

        linkSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivitySignin.class));
            }
        });

        SharedPreferences userDetailsSharedPref = getSharedPreferences("USER_LOGIN", MODE_PRIVATE);
        userName =  userDetailsSharedPref.getString("USER_NAME", "");
        password =  userDetailsSharedPref.getString("PASSWORD", "");

        etUserName.setText(userName);
        etPassword.setText(password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.equals(etUserName.getText().toString()) && password.equals(etPassword.getText().toString())) {
                    startActivity(new Intent(getApplicationContext(), ActivityHome.class));
                } else
                    Toast.makeText(getApplicationContext(),"UserName or Password is wrong !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}