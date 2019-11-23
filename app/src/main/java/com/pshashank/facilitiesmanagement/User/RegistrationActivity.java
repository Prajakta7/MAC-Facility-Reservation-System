package com.pshashank.facilitiesmanagement.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.Controllers.UserDatabaseController;
import com.pshashank.facilitiesmanagement.LoginActivity;
import com.pshashank.facilitiesmanagement.R;

public class RegistrationActivity extends AppCompatActivity {

    private TextView redirect;
    private Button register;
    private EditText firstname;
    private EditText lastname;
    private EditText utaid;
    private EditText phone;
    private EditText email;
    private EditText address;
    private EditText city;
    private EditText state;
    private EditText zip;
    private EditText username;
    private EditText password;
    private EditText confirmpassword;
    UserDatabaseController obj = new UserDatabaseController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView app_name = (TextView) findViewById(R.id.app_name);
        //Custom font`
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "Raleway-SemiBold.ttf");
        app_name.setTypeface(custom_font);

        firstname = (EditText)findViewById(R.id.firstname);
        lastname = (EditText)findViewById(R.id.lastname);
        utaid = (EditText)findViewById(R.id.utaid);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        address = (EditText)findViewById(R.id.address);
        city = (EditText)findViewById(R.id.city);
        state = (EditText)findViewById(R.id.state);
        zip = (EditText)findViewById(R.id.zip);
        username = (EditText)findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);

        Resources res = getResources();
        String[] States = res.getStringArray(R.array.states);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_dropdown_item_1line,States);
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.state);
        actv.setThreshold(1);
        actv.setAdapter(adapter);

        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(utaid.getText()!= null & username.getText()!= null & password.getText()!= null & firstname.getText() != null){
                    if(password.getText().toString().equals(confirmpassword.getText().toString())) {
                        User user = new User();
                        user.setFName(firstname.getText().toString());
                        user.setLName(lastname.getText().toString());
                        user.setUTAID(utaid.getText().toString());
                        user.setPhone(phone.getText().toString());
                        user.setEmail(email.getText().toString());
                        user.setAddress(address.getText().toString());
                        user.setCity(city.getText().toString());
                        user.setState(state.getText().toString());
                        user.setZip(zip.getText().toString());
                        obj.insertUser("user", username.getText().toString(), password.getText().toString(),user);
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegistrationActivity.this, "Please fill all required fields marked *", Toast.LENGTH_SHORT).show();
                }
                Intent in = new Intent(RegistrationActivity.this, UserHomeScreen.class);
                startActivity(in);
            }
        });

        redirect = (TextView) findViewById(R.id.redirect);
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });
    }
}
