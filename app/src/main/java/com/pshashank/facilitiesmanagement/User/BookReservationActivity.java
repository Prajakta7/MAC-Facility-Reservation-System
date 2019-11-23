package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pshashank.facilitiesmanagement.Controllers.ReservationsDatabaseController;
import com.pshashank.facilitiesmanagement.POJO.Reservation;
import com.pshashank.facilitiesmanagement.R;

public class BookReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_reservation);

        Button confirbooking = findViewById(R.id.confirbooking);
        ReservationsDatabaseController obj = new ReservationsDatabaseController(BookReservationActivity.this);

        Intent intent = getIntent();
        Reservation reservation = (Reservation) intent.getSerializableExtra("Reservation");

        confirbooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = obj.insertReservation(reservation);
                if (res){
                    Intent in = new Intent(BookReservationActivity.this, UserHomeScreen.class);
                    startActivity(in);
                }
                else{
                    Toast.makeText(BookReservationActivity.this,"Booking Unsuccessfull",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
