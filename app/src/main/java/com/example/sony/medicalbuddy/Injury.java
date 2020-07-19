package com.example.sony.medicalbuddy;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sony on 10/4/2015.
 */
public class Injury extends Activity implements OnClickListener {


    Button notifybttn, YesAmbulancebttn, NoAmbulancebttn;
    EditText UserSymptom;
    String symptom;
    MultiAutoCompleteTextView multi;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injury);

        list = new ArrayList<String>();
        list.add("Headache");
        list.add("Chest pain");
        list.add("Vision problem");
        list.add("Dizziness");
        list.add("Fatigue");
        list.add("Deepan");
        list.add("High fever");
        list.add("Vomiting");
        list.add("Skin rash");
        list.add("Trouble breathing");
        list.add("Abdominal pain");

        multi = (MultiAutoCompleteTextView) findViewById(R.id.Injury);
       // UserSymptom = (EditText) findViewById(R.id.Injury);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        multi.setAdapter(adp);
        multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multi.setThreshold(1);


        symptom = multi.getText().toString();
        //symptom= UserSymptom.getText().toString();
        notifybttn = (Button) findViewById(R.id.notifybttn);
        notifybttn.setOnClickListener(this);
    }

    public void onClick(View view) {

        //parse
        final ParseObject Symptoms = new ParseObject("Symptoms");
        Symptoms.put("Symptom", multi.getText().toString());

        final Dialog dialog = new Dialog(Injury.this);
        dialog.setContentView(R.layout.popup3);
        dialog.setTitle("Ambulance?");
        dialog.show();

        YesAmbulancebttn = (Button) dialog.findViewById(R.id.YesAmbulancebttn);
        NoAmbulancebttn = (Button) dialog.findViewById(R.id.NoAmbulancebttn);

        YesAmbulancebttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Symptoms.put("Ambulance", "Ambulance Requested");
                Symptoms.saveInBackground();
                dialog.dismiss();
                startActivity(new Intent(Injury.this, DialogContacts.class));
            }
        });

        NoAmbulancebttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Symptoms.put("Ambulance", "Ambulance Not Requested");
                Symptoms.saveInBackground();
                dialog.dismiss();
                startActivity(new Intent(Injury.this, DialogContacts.class));
            }
        });

        if(symptom.matches("headache && vision problem && chest pain||dizziness")){

            String disease="High Blood Pressure";
            Symptoms.put("Diagnosis", disease);
            Symptoms.saveInBackground();
        }

        else if (symptom.matches("high fever && muscle,joint pain && vomitting||fatigue||skin rash")){

            String disease="Dengue";
            Symptoms.put("Diagnosis", disease);
            Symptoms.saveInBackground();

        }

        else if (symptom.matches("trouble breathing && itching mouth && abdominal pain||vomitting||skin rash")){

            String disease="Food Allergic";
            Symptoms.put("Diagnosis", disease);
            Symptoms.saveInBackground();
        }

        }



         /*calculate & send location codes, ambulance string*/



}










