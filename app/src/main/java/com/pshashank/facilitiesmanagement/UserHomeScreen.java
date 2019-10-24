package com.pshashank.facilitiesmanagement;

import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UserHomeScreen extends LoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);

        Button viewreservation = (Button) findViewById(R.id.viewreservation);
        viewreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, ViewReservationsActivity.class);
                startActivity(in);
            }
        });

        Button requestreservation = (Button) findViewById(R.id.requestreservation);
        requestreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, RequestReservationActivity.class);
                startActivity(in);
            }
        });

        Button viewviolations = (Button) findViewById(R.id.viewviolations);
        viewviolations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, RequestReservationActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    @SuppressLint("RestrictedApi")
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main_menu,menu);

        if(menu instanceof MenuBuilder){

            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent in;
        switch (item.getItemId()) {
            case R.id.logout:
//                Toast.makeText(getApplicationContext(),"Add Clicked",Toast.LENGTH_LONG).show();
                 in = new Intent(UserHomeScreen.this, LoginActivity.class);
                startActivity(in);
                return true;

            case R.id.viewprofile:
                in = new Intent(UserHomeScreen.this, UserProfileActivity.class);
                startActivity(in);
                return true;
        }
        return true;
    }
}
