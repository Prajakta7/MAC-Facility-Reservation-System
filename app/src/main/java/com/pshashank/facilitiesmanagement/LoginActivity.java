package com.pshashank.facilitiesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button signup;
    public static final String ADMIN = "admin" ;
    public static final String FM = "facility_manager" ;
    public static final String USER = "user" ;
    DatabaseController obj = new DatabaseController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SQLiteDatabase db = obj.getReadableDatabase();
//        boolean res = obj.insertUser(FM,"jdoe","pass","jane","doe","1244567890","jane.doe@mavs.uta.edu","Summit Ave","Arlington","Texas","76013");
//        if(res){
//            Log.d("----->SQLInsert","Inserted");
//        }
        TextView app_name = (TextView) findViewById(R.id.app_name);
        //Custom font`
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Raleway-SemiBold.ttf");
        app_name.setTypeface(custom_font);
        username = (EditText)findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor cur = obj.getUser(username.getText().toString(), password.getText().toString());
                    if (cur != null) {
                        if (cur.moveToFirst()) {
                            int index;

                            index = cur.getColumnIndexOrThrow("user_type");
                            String type = cur.getString(index);
                            Intent in;
                            switch (type) {
                                case ADMIN:
                                    in = new Intent(LoginActivity.this, AdminHomeScreen.class);
                                    startActivity(in);
                                    break;
                                case FM:
                                    in = new Intent(LoginActivity.this, FMActivity.class);
                                    startActivity(in);
                                    break;
                                case USER:
                                    in = new Intent(LoginActivity.this, UserHomeScreen.class);
                                    startActivity(in);
                                    break;
                            }
                        } else
                            Toast.makeText(LoginActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();

                    }
                }
                catch(Exception e){
                    Log.d("------>SQLError",e.toString());
                }
            }
        });
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(in);
            }
        });

    }
}
