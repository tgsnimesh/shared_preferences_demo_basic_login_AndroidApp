package com.example.layoutpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySignin extends AppCompatActivity {

    EditText etUserName, etPassword;

    Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etUserName = findViewById(R.id.userName);
        etPassword = findViewById(R.id.password);

        btnSignin = findViewById(R.id.btnLogin);

        SharedPreferences userSharedPref = getSharedPreferences("USER_LOGIN", MODE_PRIVATE);

        btnSignin.setOnClickListener(new View.OnClickListener() {

            String userName, password;

            @Override
            public void onClick(View v) {

                userName = etUserName.getText().toString();
                password = etPassword.getText().toString();

                if(userName.isEmpty() || password.isEmpty())
                    Toast.makeText(getApplicationContext(),"User name or Password is Empty!", Toast.LENGTH_SHORT).show();
                else{
                    SharedPreferences.Editor userSharedPrefEditor = userSharedPref.edit();
                    userSharedPrefEditor.putString("USER_NAME", userName);
                    userSharedPrefEditor.putString("PASSWORD", password);

                    if (userSharedPrefEditor.commit()) {
                        Toast.makeText(getApplicationContext(),"Successful Sign in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), ActivityHome.class));
                    }

                }
            }

        });

    }
}
