package com.pshashank.facilitiesmanagement.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.pshashank.facilitiesmanagement.Controllers.ReservationsDatabaseController;
import com.pshashank.facilitiesmanagement.POJO.Reservation;
import com.pshashank.facilitiesmanagement.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

public class ViewSpecificReservationActivity extends AppCompatActivity {

    protected ReservationsDatabaseController obj = new ReservationsDatabaseController(ViewSpecificReservationActivity.this);
    Intent intent = getIntent();
    protected Reservation reservation = (Reservation) intent.getSerializableExtra("Reservation");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_specific_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView startdate = findViewById(R.id.startdate);
        TextView starttime = findViewById(R.id.starttime);
        TextView facilitytype = findViewById(R.id.facilitytype);
        TextView facilityname = findViewById(R.id.facilityname);




        startdate.setText(reservation.getStartDate());
        starttime.setText(reservation.getStartTime());
        facilitytype.setText(reservation.getFacilityType());
        facilityname.setText(reservation.getFacilityVenue());

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
            case R.id.editreservation:
//                Toast.makeText(getApplicationContext(),"Add Clicked",Toast.LENGTH_LONG).show();
                in = new Intent(ViewSpecificReservationActivity.this, ModifyReservationActivity.class);
                startActivity(in);
                return true;

            case R.id.deletereservation:
                SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
                String UTAID = pref.getString("UTAID", null);
                int res = obj.deleteReservation(UTAID,reservation.getFacilityVenue(),reservation.getStartDate(),reservation.getStartTime());
                if (res > 0){
                    Toast.makeText(ViewSpecificReservationActivity.this,"Reservation Deleted",Toast.LENGTH_LONG).show();
                    in = new Intent(ViewSpecificReservationActivity.this, ViewReservationsActivity.class);
                    startActivity(in);
                    return true;
                }
                else{
                    Toast.makeText(ViewSpecificReservationActivity.this,"Unable to delete",Toast.LENGTH_LONG).show();
                    return false;
                }

        }
        return true;
    }
}
