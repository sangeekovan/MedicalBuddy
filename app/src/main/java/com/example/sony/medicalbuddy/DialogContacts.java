package com.example.sony.medicalbuddy;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by Sangeeta Ellankovan on 22/10/2015.
 */
public class DialogContacts extends Activity {

    Button YesAlertbttn, NoAlertbttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.injury);

        final Dialog dialog = new Dialog(DialogContacts.this);
        dialog.setContentView(R.layout.popup2);
        dialog.setTitle("Alert Emergency Contacts");
        dialog.show();

        // the dialog components
        YesAlertbttn = (Button) dialog.findViewById(R.id.YesAlertbttn);
        NoAlertbttn = (Button) dialog.findViewById(R.id.NoAlertbttn);

        YesAlertbttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //alert the emergency contact

                dialog.dismiss();
                startActivity(new Intent(DialogContacts.this, HospitalNotified.class));
            }
        });

        NoAlertbttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(DialogContacts.this, HospitalNotified.class));
            }
        });




    }
}