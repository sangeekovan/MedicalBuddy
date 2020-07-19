package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;



/**
 * Created by sony on 9/20/2015.
 */
public class UserProfile extends Activity implements View.OnClickListener {


    EditText firstname, lastname, birthdate, address,contact,gender;
    Button nextbttn;





    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);


        firstname= (EditText) findViewById(R.id.FirstName);
        lastname =(EditText) findViewById(R.id.LastName);
        birthdate= (EditText) findViewById(R.id.BirthDate);
        gender= (EditText) findViewById(R.id.gender);
        address =(EditText) findViewById(R.id.Address);
        contact= (EditText) findViewById(R.id.ContactNum);
        nextbttn=(Button) findViewById(R.id.nextbuttonprofile);
        nextbttn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent inte = new Intent(getApplicationContext(), UserProfile2.class);

        inte.putExtra("Firstname", firstname.getText().toString());
        inte.putExtra("Lastname", lastname.getText().toString());
        inte.putExtra("Gender", gender.getText().toString());
        inte.putExtra("Birthdate", birthdate.getText().toString());
        inte.putExtra("Address", address.getText().toString());
        inte.putExtra("Contact", contact.getText().toString());

        startActivity(inte);

    }
}

