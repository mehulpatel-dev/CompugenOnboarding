package com.mehul.compugenonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Submitted extends AppCompatActivity {

    TextView ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted);

        ref = (TextView) findViewById(R.id.refTextView);

        Random ran = new Random();
        int randomNumber = ran.nextInt(999999);

        //set condition to check if reference number already exists in db if so then create a new ref number

        //display reference number in the text view
        ref.setText(ref.getText() + ": " + Integer.toString(randomNumber));
    }
}