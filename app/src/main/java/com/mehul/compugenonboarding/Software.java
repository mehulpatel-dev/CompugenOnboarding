package com.mehul.compugenonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Software extends AppCompatActivity {

    CheckBox crm, visio, project;
    EditText other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software);

        crm = (CheckBox) findViewById(R.id.crmCheckBox);
        visio = (CheckBox) findViewById(R.id.msvisioCheckBox);
        project = (CheckBox) findViewById(R.id.msprojectCheckBox);
        other = (EditText) findViewById(R.id.otherMultitext);

        software();
    }

    public void software(){
        crm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(crm.isChecked()){
                    //do something if crm check box is clicked
                }
            }
        });

        visio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(visio.isChecked()){
                    //do something if visio check box is clicked
                }
            }
        });

        project.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(project.isChecked()){
                    //do something if project check box is clicked
                }
            }
        });
    }

    public void Next(View v){
        Intent hardware = new Intent(getApplicationContext(), Hardware.class);
        startActivity(hardware);
    }
}