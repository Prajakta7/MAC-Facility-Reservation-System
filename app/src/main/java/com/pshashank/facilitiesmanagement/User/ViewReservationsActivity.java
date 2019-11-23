package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.pshashank.facilitiesmanagement.Adapters.ReservationAdapter;
import com.pshashank.facilitiesmanagement.Controllers.ReservationsDatabaseController;
import com.pshashank.facilitiesmanagement.POJO.Reservation;
import com.pshashank.facilitiesmanagement.R;

import java.util.ArrayList;

public class ViewReservationsActivity extends AppCompatActivity {

    ReservationAdapter reservationAdapter;
    ReservationsDatabaseController obj = new ReservationsDatabaseController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservations);

        ReservationsDatabaseController obj = new ReservationsDatabaseController(ViewReservationsActivity.this);
        RecyclerView recList = (RecyclerView) findViewById(R.id.reservationList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
        String utaid = pref.getString("UTAID", null);
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        Cursor cur = obj.getReservation(utaid);
        if (cur != null) {
            if (cur.moveToFirst()) {
                while (cur.moveToNext()) {
                    Reservation r = new Reservation();
                    r.setFacilityVenue( cur.getString(cur.getColumnIndexOrThrow("venue_name")));
                    r.setFacilityType( cur.getString(cur.getColumnIndexOrThrow("venue_type")));
                    r.setStartDate( cur.getString(cur.getColumnIndexOrThrow("phone")));
                    r.setStartTime( cur.getString(cur.getColumnIndexOrThrow("email")));

                    reservationList.add(r);
                }
            }
        }

        reservationAdapter = new ReservationAdapter(reservationList);
    }
}
