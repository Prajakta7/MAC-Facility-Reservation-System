package com.pshashank.facilitiesmanagement.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

import com.pshashank.facilitiesmanagement.Adapters.UserAdapter;
import com.pshashank.facilitiesmanagement.Controllers.UserDatabaseController;
import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.R;

import java.util.ArrayList;

public class SearchUserActivity extends AppCompatActivity {

    UserAdapter userAdapter;
    UserDatabaseController obj = new UserDatabaseController(this);
    EditText lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        lastname = findViewById(R.id.lastname);

        RecyclerView recList = (RecyclerView) findViewById(R.id.userList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ArrayList<User> userList = new ArrayList<User>();
        Cursor cur = obj.searchUser(lastname.getText().toString());
        if (cur != null) {
            if (cur.moveToFirst()) {
                while (cur.moveToNext()) {
                    User u = new User();
                    u.setFName( cur.getString(cur.getColumnIndexOrThrow("first_name")));
                    u.setLName( cur.getString(cur.getColumnIndexOrThrow("last_name")));
                    u.setPhone( cur.getString(cur.getColumnIndexOrThrow("phone")));
                    u.setEmail( cur.getString(cur.getColumnIndexOrThrow("email")));
                    u.setAddress( cur.getString(cur.getColumnIndexOrThrow("street_address")));
                    u.setCity( cur.getString(cur.getColumnIndexOrThrow("city")));
                    u.setState( cur.getString(cur.getColumnIndexOrThrow("state")));
                    u.setZip( cur.getString(cur.getColumnIndexOrThrow("zip_code")));
                    userList.add(u);
                }
            }
        }


        userAdapter = new UserAdapter(userList);

    }
}
