package com.example.sony.medicalbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntroActivity extends Activity implements OnClickListener {

    Button registerbttn, loginbttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        registerbttn = (Button) findViewById(R.id.registerbttn);
        loginbttn = (Button) findViewById(R.id.loginbttn);

        registerbttn.setOnClickListener(this);
        loginbttn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

       switch (v.getId()) {
       case R.id.registerbttn:
           startActivity(new Intent (this, RegisterActivity.class));
            break;

         case R.id.loginbttn:
            startActivity(new Intent (this, Login.class));
             break;
                }



            }



    }





