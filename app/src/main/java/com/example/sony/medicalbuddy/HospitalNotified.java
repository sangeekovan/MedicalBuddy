package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sangeeta Ellankovan on 23/10/2015.
 */
public class HospitalNotified extends Activity {


        Button backbttn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.notified);

            backbttn= (Button) findViewById(R.id.backbttn);
            backbttn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(HospitalNotified.this, Homepage.class));
                }
            });


        }

}
