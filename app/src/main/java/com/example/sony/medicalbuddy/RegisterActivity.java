package com.example.sony.medicalbuddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.parse.Parse;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ParseObject;
import android.content.Context;
import android.widget.Toast;

public class RegisterActivity extends Activity implements View.OnClickListener {


    EditText Email, NewUsername, NewPassword;
    Button Registerbttn;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);



        Email = (EditText) findViewById(R.id.Email);
        NewUsername = (EditText) findViewById(R.id.NewUsername);
        NewPassword = (EditText) findViewById(R.id.NewPassword);
        Registerbttn=(Button)findViewById(R.id.registerButton);
        Registerbttn.setOnClickListener(this);


    }

    public void onClick(View v) {

    // Validate the sign up data
    boolean validationError = false;
    StringBuilder validationErrorMessage =
            new StringBuilder("Please");

        if (isEmpty(Email)) {
            validationError = true;
            validationErrorMessage.append("enter email");
        }

        if (isEmpty(NewUsername)) {
        validationError = true;
        validationErrorMessage.append("enter username");
    }
    if (isEmpty(NewPassword)) {
        if (validationError) {
            validationErrorMessage.append("and");
        }
        validationError = true;
        validationErrorMessage.append("enter password.");
    }



    // If there is a validation error, display the error
    if (validationError) {
        Toast.makeText(RegisterActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                .show();
        return;
    }

    // Set up a progress dialog
    final ProgressDialog dlg = new ProgressDialog(RegisterActivity.this);
    dlg.setTitle("Please wait.");
    dlg.setMessage("Signing up.  Please wait.");
    dlg.show();

    // Set up a new Parse user
        ParseUser user = new ParseUser();
        user.setEmail(Email.getText().toString());
        user.setUsername(NewUsername.getText().toString());
        user.setPassword(NewPassword.getText().toString());

    // Call the Parse signup method
    user.signUpInBackground(new SignUpCallback() {

        @Override
        public void done(ParseException e) {
            dlg.dismiss();
            if (e != null) {
                // Show the error message
                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            } else {
                // Start an intent for the dispatch activity
                Intent intent = new Intent(RegisterActivity.this, DispatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    });
}


public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
        return false;
        } else {
        return true;
        }
        }

}




