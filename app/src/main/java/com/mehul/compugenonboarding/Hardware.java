package com.mehul.compugenonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Hardware extends AppCompatActivity {

    CheckBox laptop, dock, monitor, mouse, keyboard, fob, mobile;
    EditText other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);

        laptop = (CheckBox) findViewById(R.id.laptopCheckBox);
        dock = (CheckBox) findViewById(R.id.dockingStationCheckBox);
        monitor = (CheckBox) findViewById(R.id.monitorCheckBox);
        mouse = (CheckBox) findViewById(R.id.mousecheckBox);
        keyboard = (CheckBox) findViewById(R.id.keyboardcheckbox);
        fob = (CheckBox) findViewById(R.id.keyFobCheckBox);
        mobile = (CheckBox) findViewById(R.id.mobilePhoneCheckBox);

        other = (EditText) findViewById(R.id.otherEditText);

        hardware();
    }

    public void hardware(){
        laptop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(laptop.isChecked()){
                    //do something if laptop check box is clicked
                }
            }
        });

        dock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(dock.isChecked()){
                    //do something if dock check box is clicked
                }
            }
        });

        monitor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(monitor.isChecked()){
                    //do something if monitor check box is clicked
                }
            }
        });

        mouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mouse.isChecked()){
                    //do something if mouse check box is clicked
                }
            }
        });

        keyboard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(keyboard.isChecked()){
                    //do something if keyboard check box is clicked
                }
            }
        });

        mobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(mobile.isChecked()){
                    //do something if mobile phone check box is clicked
                }
            }
        });

        fob.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(fob.isChecked()){
                    //do something if key fob check box is clicked
                }
            }
        });
    }

    public void Submit(View v){
        Intent submit = new Intent(getApplicationContext(), Submitted.class);
        startActivity(submit);
    }
}