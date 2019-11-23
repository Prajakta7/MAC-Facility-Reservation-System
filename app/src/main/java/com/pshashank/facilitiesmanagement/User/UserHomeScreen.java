package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.pshashank.facilitiesmanagement.LoginActivity;
import com.pshashank.facilitiesmanagement.R;
import com.pshashank.facilitiesmanagement.UserProfileActivity;

public class UserHomeScreen extends LoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_screen);

        CardView viewreservation = findViewById(R.id.viewreservation);
        viewreservation.setBackgroundResource(R.drawable.custom_card);
        viewreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, ViewReservationsActivity.class);
                startActivity(in);
            }
        });

        CardView requestreservation = findViewById(R.id.requestreservation);
        requestreservation.setBackgroundResource(R.drawable.custom_card);
        requestreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, RequestReservationActivity.class);
                startActivity(in);
            }
        });

        CardView viewviolations = findViewById(R.id.viewviolations);
        viewviolations.setBackgroundResource(R.drawable.custom_card);
        viewviolations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(UserHomeScreen.this, ViewViolationsActivity.class);
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
