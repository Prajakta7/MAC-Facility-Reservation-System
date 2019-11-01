package com.pshashank.facilitiesmanagement;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pshashank.facilitiesmanagement.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
        String Username = pref.getString("Username", null);
        String Password = pref.getString("Password", null);
        String FirstName = pref.getString("FirstName", null);
        String LastName = pref.getString("LastName", null);
        String UTAID = pref.getString("UTAID", null);
        String uphone = pref.getString("phone", null);
        String uemail = pref.getString("email", null);
        String uaddress = pref.getString("address", null);
        String ucity = pref.getString("city", null);
        String ustate = pref.getString("state", null);
        String uzip = pref.getString("zip", null);

        TextView uname = findViewById(R.id.uname);
        TextView fname = findViewById(R.id.fname);
        TextView lname = findViewById(R.id.lname);
        TextView id = findViewById(R.id.utaid);
        TextView phone = findViewById(R.id.phone);
        TextView email = findViewById(R.id.email);
        TextView address = findViewById(R.id.streetadd);
        TextView city = findViewById(R.id.city);
        TextView state = findViewById(R.id.state);
        TextView zip = findViewById(R.id.zipcode);

        uname.setVisibility(View.VISIBLE);
        uname.setText(Username);
        fname.setVisibility(View.VISIBLE);
        fname.setText(FirstName);
        lname.setVisibility(View.VISIBLE);
        lname.setText(LastName);
        id.setVisibility(View.VISIBLE);
        id.setText(UTAID);
        phone.setVisibility(View.VISIBLE);
        phone.setText(uphone);
        email.setVisibility(View.VISIBLE);
        email.setText(uemail);
        address.setVisibility(View.VISIBLE);
        address.setText(uaddress);
        city.setVisibility(View.VISIBLE);
        city.setText(ucity);
        state.setVisibility(View.VISIBLE);
        state.setText(ustate);
        zip.setVisibility(View.VISIBLE);
        zip.setText(uzip);
    }
}
