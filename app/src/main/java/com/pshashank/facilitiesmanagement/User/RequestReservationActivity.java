package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pshashank.facilitiesmanagement.R;

public class RequestReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_reservation);

        Button requestreservation = (Button) findViewById(R.id.requestreservation);
        requestreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(RequestReservationActivity.this, BookReservationActivity.class);
                startActivity(in);
            }
        });
    }
}
