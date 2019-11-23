package com.pshashank.facilitiesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pshashank.facilitiesmanagement.Admin.AdminHomeScreen;
import com.pshashank.facilitiesmanagement.Controllers.UserDatabaseController;
import com.pshashank.facilitiesmanagement.FacilityManager.FMActivity;
import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.User.RegistrationActivity;
import com.pshashank.facilitiesmanagement.User.UserHomeScreen;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    public static final String ADMIN = "admin" ;
    public static final String FM = "facility_manager" ;
    public static final String USER = "user" ;
    UserDatabaseController obj = new UserDatabaseController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        User user = new User();
        user.setFName("jdoe");
        user.setLName("pass");
        user.setUTAID("1001652446");
        user.setPhone("1244567890");
        user.setEmail("jane.doe@mavs.uta.edu");
        user.setAddress("Summit Ave");
        user.setCity("Arlington");
        user.setState("Texas");
        user.setZip("76013");

//        SQLiteDatabase db = obj.getReadableDatabase();
//        boolean res = obj.insertUser(USER,"jdoe","pass",user);
//        if(res){
//            Log.d("----->SQLInsert","Inserted");
//        }
        TextView app_name =  findViewById(R.id.app_name);
        //Custom font`
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Raleway-SemiBold.ttf");
        app_name.setTypeface(custom_font);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Button login;
        Button signup;

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor cur = obj.getUser(username.getText().toString(), password.getText().toString());
                    if (cur != null) {
                        if (cur.moveToFirst()) {
                            int index;

                            SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("Type", cur.getString(cur.getColumnIndexOrThrow("user_type")));
                            editor.putString("Username", cur.getString(cur.getColumnIndexOrThrow("user_uname")));
                            editor.putString("Password", cur.getString(cur.getColumnIndexOrThrow("user_pass")));
                            editor.putString("FirstName", cur.getString(cur.getColumnIndexOrThrow("first_name")));
                            editor.putString("LastName", cur.getString(cur.getColumnIndexOrThrow("last_name")));
                            editor.putString("UTAID", cur.getString(cur.getColumnIndexOrThrow("user_id")));
                            editor.putString("phone", cur.getString(cur.getColumnIndexOrThrow("phone")));
                            editor.putString("email", cur.getString(cur.getColumnIndexOrThrow("email")));
                            editor.putString("address", cur.getString(cur.getColumnIndexOrThrow("street_address")));
                            editor.putString("city", cur.getString(cur.getColumnIndexOrThrow("city")));
                            editor.putString("state", cur.getString(cur.getColumnIndexOrThrow("state")));
                            editor.putString("zip", cur.getString(cur.getColumnIndexOrThrow("zip_code")));
                            editor.apply();

                            index = cur.getColumnIndexOrThrow("user_type");
                            String type = cur.getString(index);
                            Intent in = redirect(LoginActivity.this, type);
                            startActivity(in);

                        } else
                            Toast.makeText(LoginActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();

                    }
                }
                catch(Exception e){
                    Log.d("------>SQLError",e.toString());
                }
            }
        });
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(in);
            }
        });

    }
    public static Intent redirect(Context context, String type){
        Intent in = new Intent();
        switch (type) {
            case ADMIN:
                in = new Intent(context, AdminHomeScreen.class);
                break;
            case FM:
                in = new Intent(context, FMActivity.class);
                break;
            case USER:
                in = new Intent(context, UserHomeScreen.class);
                break;
        }
        return in;
    }
}
