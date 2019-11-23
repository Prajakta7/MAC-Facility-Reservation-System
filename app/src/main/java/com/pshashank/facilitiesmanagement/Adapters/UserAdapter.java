package com.pshashank.facilitiesmanagement.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pshashank.facilitiesmanagement.Admin.ViewSpecificUserActivity;
import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.R;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> userList;

    public UserAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        User user = userList.get(i);
        userViewHolder.userFname.setText(user.getFName());
        userViewHolder.userLname.setText(user.getLName());
        userViewHolder.userPhone.setText(user.getPhone());
        userViewHolder.userEmail.setText(user.getEmail());

        userViewHolder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), ViewSpecificUserActivity.class);
                in.putExtra("User",(Serializable) user);
                view.getContext().startActivity(in);
            }
        });
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.useritem, viewGroup, false);

        return new UserViewHolder(itemView);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        protected TextView userFname;
        protected TextView userLname;
        protected TextView userEmail;
        protected TextView userPhone;
        protected RelativeLayout parentlayout;

        public UserViewHolder(View v) {
            super(v);
            userFname =  (TextView) v.findViewById(R.id.userFname);
            userLname = (TextView)  v.findViewById(R.id.userLname);
            userEmail = (TextView)  v.findViewById(R.id.userEmail);
            userPhone = (TextView) v.findViewById(R.id.userPhone);
            parentlayout = v.findViewById(R.id.parent_layout);
        }
    }
}
