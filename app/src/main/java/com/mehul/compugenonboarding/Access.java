package com.mehul.compugenonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Access extends AppCompatActivity {

    CheckBox ad, email, emerge, citrix, finesse;
    EditText other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        ad = (CheckBox) findViewById(R.id.activedirectoryCheckBox);
        email = (CheckBox) findViewById(R.id.emailCheckBox);
        emerge = (CheckBox) findViewById(R.id.emergeCheckBox);
        citrix = (CheckBox) findViewById(R.id.citrixCheckBox);
        finesse = (CheckBox) findViewById(R.id.finesseCheckBox);
        other = (EditText) findViewById(R.id.otherEditText);

        access();

    }

    public void access(){
        ad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ad.isChecked()){
                    //do something if AD check box is clicked
                }
            }
        });

        email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(email.isChecked()){
                    //do something if email check box is clicked
                }
            }
        });

        emerge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(emerge.isChecked()){
                    //do something if emerge check box is clicked
                }
            }
        });

        citrix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(citrix.isChecked()){
                    //do something if citrix check box is clicked
                }
            }
        });

        finesse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(finesse.isChecked()){
                    //do something if finesse check box is clicked
                }
            }
        });
    }


    public void Next(View v){
        Intent software = new Intent(getApplicationContext(), Software.class);
        startActivity(software);
    }
}