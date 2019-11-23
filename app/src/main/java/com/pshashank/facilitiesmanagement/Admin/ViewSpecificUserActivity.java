package com.pshashank.facilitiesmanagement.Admin;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.R;

public class ViewSpecificUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_specific_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView fname = findViewById(R.id.fname);
        TextView lname = findViewById(R.id.lname);
        TextView id = findViewById(R.id.utaid);
        TextView phone = findViewById(R.id.phone);
        TextView email = findViewById(R.id.email);
        TextView address = findViewById(R.id.streetadd);
        TextView city = findViewById(R.id.city);
        TextView state = findViewById(R.id.state);
        TextView zip = findViewById(R.id.zipcode);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("User");

        fname.setVisibility(View.VISIBLE);
        fname.setText(user.getFName());
        lname.setVisibility(View.VISIBLE);
        lname.setText(user.getLName());
        id.setVisibility(View.VISIBLE);
        id.setText(user.getUTAID());
        phone.setVisibility(View.VISIBLE);
        phone.setText(user.getPhone());
        email.setVisibility(View.VISIBLE);
        email.setText(user.getEmail());
        address.setVisibility(View.VISIBLE);
        address.setText(user.getEmail());
        city.setVisibility(View.VISIBLE);
        city.setText(user.getCity());
        state.setVisibility(View.VISIBLE);
        state.setText(user.getState());
        zip.setVisibility(View.VISIBLE);
        zip.setText(user.getZip());
    }
}
