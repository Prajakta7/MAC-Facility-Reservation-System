package com.pshashank.facilitiesmanagement.FacilityManager;

import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pshashank.facilitiesmanagement.LoginActivity;
import com.pshashank.facilitiesmanagement.R;
import com.pshashank.facilitiesmanagement.UserProfileActivity;

public class FMActivity extends LoginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fm);
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
                in = new Intent(FMActivity.this, LoginActivity.class);
                startActivity(in);
                return true;

            case R.id.viewprofile:
                in = new Intent(FMActivity.this, UserProfileActivity.class);
                startActivity(in);
                return true;
        }
        return true;
    }
}
