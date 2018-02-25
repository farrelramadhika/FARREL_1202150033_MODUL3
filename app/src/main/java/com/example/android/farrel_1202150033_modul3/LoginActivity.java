package com.example.android.farrel_1202150033_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLogin(View view) {
        user = (EditText) findViewById(R.id.etUser);
        pass = (EditText) findViewById(R.id.etPass);
        String username="EAD";
        String password="MOBILE";
        if (user.getText().toString().equals(username) && pass.getText().toString().equals(password)){
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Login Failed, Try Again!", Toast.LENGTH_SHORT).show();
        }
    }

}
