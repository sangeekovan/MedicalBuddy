package com.example.sony.medicalbuddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Sangeeta Ellankovan on 19/10/2015.
 */
public class ParseKey extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "wnITrSCa4phTcD32LB3Vum7pO2JjMrPg2l06gj7n", "NTJtLmhnLtkmjwohLK1XeZDBeTM3MqNmwbNfFKDE");
    }



}
