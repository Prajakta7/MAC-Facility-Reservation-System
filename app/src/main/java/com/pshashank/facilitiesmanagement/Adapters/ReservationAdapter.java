package com.pshashank.facilitiesmanagement.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pshashank.facilitiesmanagement.POJO.Reservation;
import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.R;
import com.pshashank.facilitiesmanagement.User.ViewSpecificReservationActivity;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>{

    private ArrayList<Reservation> reservationsList;

    public ReservationAdapter(ArrayList<Reservation> userList) {
        this.reservationsList = reservationsList;
    }

    public int getItemCount() {
        return reservationsList.size();
    }

    public void onBindViewHolder(ReservationViewHolder reservationViewHolder, int i) {
        Reservation reservation = reservationsList.get(i);
        reservationViewHolder.facilityname.setText(reservation.getFacilityVenue());
        reservationViewHolder.facilitytype.setText(reservation.getFacilityType());
        reservationViewHolder.reservationdate.setText(reservation.getStartDate());
        reservationViewHolder.reservationtime.setText(reservation.getStartTime());

        reservationViewHolder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), ViewSpecificReservationActivity.class);
                in.putExtra("Reservation",(Serializable) reservation);
                view.getContext().startActivity(in);
            }
        });
    }

    public ReservationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.reservationitem, viewGroup, false);

        return new ReservationViewHolder(itemView);
    }

    public static class ReservationViewHolder extends RecyclerView.ViewHolder {
        protected TextView facilityname;
        protected TextView facilitytype;
        protected TextView reservationdate;
        protected TextView reservationtime;
        protected RelativeLayout parentlayout;

        public ReservationViewHolder(View v) {
            super(v);
            facilityname =  (TextView) v.findViewById(R.id.facilityname);
            facilitytype = (TextView)  v.findViewById(R.id.facilitytype);
            reservationdate = (TextView)  v.findViewById(R.id.reservationdate);
            reservationtime = (TextView) v.findViewById(R.id.reservationtime);
            parentlayout = v.findViewById(R.id.parent_layout);
        }
    }
}
