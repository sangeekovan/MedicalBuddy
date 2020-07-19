package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.sony.medicalbuddy.Homepage;
import com.example.sony.medicalbuddy.IntroActivity;
import com.parse.ParseUser;

/**
 * Created by sony on 22/10/15
 */
public class DispatchActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Check if there is current user info
        if (ParseUser.getCurrentUser() != null) {
            // Start an intent for the logged in activity
            startActivity(new Intent(this,Homepage.class));
        } else {
            // Start and intent for the logged out activity
            startActivity(new Intent(this, IntroActivity.class));
        }
    }
}
