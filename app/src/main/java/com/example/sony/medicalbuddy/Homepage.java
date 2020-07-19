package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by sony on 9/20/2015.
 */
public class Homepage extends Activity {

    final Context context = this;
    Button tapbttn,profilebttn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        tapbttn= (Button)findViewById(R.id.tapbttn);
        tapbttn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup1);
                dialog.setTitle("Who's in need of medical attention?");

                // dialog components here

                Button NotMebttn = (Button) dialog.findViewById(R.id.NotMebttn);
                Button Mebbtn = (Button) dialog.findViewById(R.id.Mebttn);

                Mebbtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(context, Injury.class));


                    }
                });


                NotMebttn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(context, OtherInjury1.class));

                    }
                });

                dialog.show();

            }
        });

        profilebttn= (Button)findViewById(R.id.profilebttn);
        profilebttn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, UserProfile.class));

            }
        });



    }



}
