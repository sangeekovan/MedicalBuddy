package com.example.sony.medicalbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;



/**
 * Created by sony on 10/4/2015.
 */
public class OtherInjury1 extends Activity implements OnClickListener{

    Button Nextbttn;
    RadioGroup PatientRadioGroup;
    RadioButton PatientRadioButton;
    String medicalcond,medication;
    EditText MedicalCond, Medication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherinjury1);

        PatientRadioGroup = (RadioGroup) findViewById(R.id.PatientRadioGroup);
        MedicalCond= (EditText) findViewById(R.id.ETMedicalCond);
        Medication=(EditText) findViewById(R.id.ETmedication);
        Nextbttn = (Button) findViewById(R.id.Nextbttn);
        Nextbttn.setOnClickListener(this);

    }


    public void onClick(View v) {

        medicalcond = MedicalCond.getText().toString();
        medication = Medication.getText().toString();



        int selectedId = PatientRadioGroup.getCheckedRadioButtonId();
        PatientRadioButton = (RadioButton) findViewById(selectedId);


        Intent in = new Intent(getApplicationContext(), OtherInjury2.class);

        in.putExtra("medicalcond", medicalcond);
        in.putExtra("medication", medication);
        in.putExtra("PatientType", PatientRadioButton.getText());


        startActivity(in);


    }



}




