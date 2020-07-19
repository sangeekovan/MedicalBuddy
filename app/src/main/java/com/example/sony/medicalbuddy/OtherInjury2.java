package com.example.sony.medicalbuddy;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;


/**
 * Created by sony on 10/4/2015.
 */
public class OtherInjury2 extends Activity implements OnClickListener {

    Button OtherNotifybttn,YesAmbulancebttn,NoAmbulancebttn;
    EditText OtherInjury;
    String Otsymptom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherinjury2);
        OtherInjury = (EditText) findViewById(R.id.OtherInjury);
        OtherNotifybttn = (Button) findViewById(R.id.OtherNotifybttn);
        OtherNotifybttn.setOnClickListener(this);
        Otsymptom= OtherInjury.getText().toString();

    }


    public void onClick(View v) {

        Intent in = getIntent();

        final ParseObject NonUserSymptom = new ParseObject("NonUserSymptom");

        NonUserSymptom.put("Symptom", OtherInjury.getText().toString());
        NonUserSymptom.put("MedicalCondition", in.getStringExtra("medicalcond"));
        NonUserSymptom.put("Medication",in.getStringExtra("medication"));
        NonUserSymptom.put("PatientType", in.getStringExtra("PatientType")); // remember to include this in the symptom for users


        final Dialog dialog = new Dialog(OtherInjury2.this);
        dialog.setContentView(R.layout.popup3);
        dialog.setTitle("Ambulance?");
        dialog.show();

        YesAmbulancebttn = (Button) dialog.findViewById(R.id.YesAmbulancebttn);
        NoAmbulancebttn = (Button) dialog.findViewById(R.id.NoAmbulancebttn);

        YesAmbulancebttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                NonUserSymptom.put("Ambulance", "Ambulance Requested");
                NonUserSymptom.saveInBackground();
                dialog.dismiss();
                startActivity(new Intent(OtherInjury2.this, DialogContacts.class));
            }
        });

        NoAmbulancebttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                NonUserSymptom.put("Ambulance", "Ambulance Not Requested");
                NonUserSymptom.saveInBackground();
                dialog.dismiss();
                startActivity(new Intent(OtherInjury2.this, DialogContacts.class));
            }
        });

        //do something to alert hospital, include location codes

        Diagnose();

    }


    public void Diagnose() {

        if (Otsymptom.matches("headache && vision problem && chest pain||dizziness")) {

            String disease = "High Blood Pressure";
            ParseObject Diagnosis = new ParseObject("Diagnosis");
            Diagnosis.put("Diagnosis", disease);
            Diagnosis.saveInBackground();
        } else if (Otsymptom.matches("high fever && muscle,joint pain && vomitting||fatigue||skinrash")) {

            String disease = "Dengue";
            ParseObject Diagnosis = new ParseObject("Diagnosis");
            Diagnosis.put("Diagnosis", disease);
            Diagnosis.saveInBackground();

        } else if (Otsymptom.matches("trouble breathing && itching mouth && abdominal pain||vomitting||skin rash")) {

            String disease = "Food Allergic";
            ParseObject Diagnosis = new ParseObject("Diagnosis");
            Diagnosis.put("Diagnosis", disease);
            Diagnosis.saveInBackground();
        }


    }

    }







