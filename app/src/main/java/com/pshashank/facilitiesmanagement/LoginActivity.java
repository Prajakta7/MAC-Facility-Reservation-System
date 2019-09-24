package com.pshashank.facilitiesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(login.getText().toString().equals("abcd")&& pass.getText().toString().equals("1234")){

                }
                else
                    Toast.makeText(LoginActivity.this,"Incorrect Credentials", Toast.LENGTH_SHORT).show();*/
                Intent in = new Intent(LoginActivity.this, FMActivity.class);
                startActivity(in);
            }
        });


    }
}
