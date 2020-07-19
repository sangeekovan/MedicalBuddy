package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by sony on 10/15/2015.
 */
public class UserProfile2 extends Activity {


        EditText EmergencyContact, InsuranceComp,InsurancePolicy, EtMedicalCondProfile,ETmedicationProfile;
        Button updatebttn;


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.userprofile2);


            EmergencyContact= (EditText) findViewById(R.id.EmergencyContact);
            InsuranceComp =(EditText) findViewById(R.id.InsuranceComp);
            InsurancePolicy= (EditText) findViewById(R.id.InsurancePolicy);
            EtMedicalCondProfile= (EditText) findViewById(R.id.EtMedicalCondProfile);
            ETmedicationProfile =(EditText) findViewById(R.id.ETmedicationProfile);

            updatebttn = (Button) findViewById(R.id.updatebttn);
            updatebttn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent inte = getIntent();

                    ParseObject UserProfile = new ParseObject("UserProfile");

                    UserProfile.put("Firstname", inte.getStringExtra("Firstname"));
                    UserProfile.put("Lastname", inte.getStringExtra("Lastname"));
                    UserProfile.put("Gender", inte.getStringExtra("Gender"));
                    UserProfile.put("Birthdate", inte.getStringExtra("Birthdate"));
                    UserProfile.put("Address", inte.getStringExtra("Address"));
                    UserProfile.put("Contact", inte.getStringExtra("Contact"));

                    UserProfile.put("EmergencyContact", EmergencyContact.getText().toString());
                    UserProfile.put("InsuranceComp", InsuranceComp.getText().toString());
                    UserProfile.put("InsurancePolicy", InsurancePolicy.getText().toString());
                    UserProfile.put("MedicalCondition", EtMedicalCondProfile.getText().toString());
                    UserProfile.put("Medication", ETmedicationProfile.getText().toString());

                    UserProfile.saveInBackground();

                    startActivity(new Intent(UserProfile2.this,Homepage.class));



                }
            });

        }






    }

