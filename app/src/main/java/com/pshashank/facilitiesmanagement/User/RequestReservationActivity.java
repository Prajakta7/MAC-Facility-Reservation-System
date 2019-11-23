package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.pshashank.facilitiesmanagement.POJO.Reservation;
import com.pshashank.facilitiesmanagement.R;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RequestReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_reservation);

        EditText startdate = findViewById(R.id.startdate);
        EditText starttime = findViewById(R.id.starttime);
//      Facility Type spinner
        Spinner typespinner = findViewById(R.id.typecategory);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Facility_Types));
        typespinner.setAdapter(dataAdapter);
//      Facility Venue spinner
        Spinner venuespinner = findViewById(R.id.venuecategory);
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Facility_Venues));
        typespinner.setAdapter(dataAdapter);

        final Calendar myCalendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year,
                                  int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, year);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(startdate, myCalendar);
            }
        },myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH),myCalendar.get(Calendar.YEAR));


        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
//                        myCalendar.set(Calendar.HOUR, hourOfDay);
//                        myCalendar.set(Calendar.MINUTE, minute);

                        starttime.setText(hourOfDay + " : " + minute);
                    }
                }, myCalendar.get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE), false);


//      Setting Date in the date field
        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               datePickerDialog.show();

            }
        });

//      Setting Time in the time field
        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timePickerDialog.show();
            }
        });


        Button requestreservation = (Button) findViewById(R.id.requestreservation);
        requestreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (typespinner.getSelectedItem() !=null && venuespinner.getSelectedItem() !=null ) {

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
                    String utaid = pref.getString("UTAID", null);
                    Reservation reservation = new Reservation();
                    reservation.setFacilityType(String.valueOf(typespinner.getSelectedItem()));
                    reservation.setFacilityVenue(String.valueOf(venuespinner.getSelectedItem()));
                    reservation.setStartDate(startdate.getText().toString());
                    reservation.setStartTime(starttime.getText().toString());
                    reservation.setUTAID(utaid);
                    Intent in = new Intent(RequestReservationActivity.this, BookReservationActivity.class);
                    in.putExtra("Reservation", (Serializable) reservation);
                    startActivity(in);
                }
                else{
                    Toast.makeText(RequestReservationActivity.this, "Please select Facility Tyoe and Venue", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void updateLabel(EditText edittext, Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

}
