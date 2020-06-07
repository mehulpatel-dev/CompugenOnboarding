package com.mehul.compugenonboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.accounts.Account;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;

public class AccountSetUp extends AppCompatActivity {

    EditText fname, lname, role, department, manager, salary, dofBirth, sDate;
    DatePickerDialog.OnDateSetListener dofbirthDateSetListener, startDateSetListener;
    CheckBox ft, pt, contract, coop;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_set_up);

        fname = (EditText) findViewById(R.id.firstNameEditText);
        lname = (EditText) findViewById(R.id.lastNameEditText);
        role = (EditText) findViewById(R.id.roleEditText);
        department = (EditText) findViewById(R.id.departmentEditText);
        manager = (EditText) findViewById(R.id.managerEditText);
        salary = (EditText) findViewById(R.id.salaryEditText);
        dofBirth = (EditText) findViewById(R.id.dobEditText);
        sDate = (EditText) findViewById(R.id.startDateEditText);
        ft = (CheckBox) findViewById(R.id.ftCheckBox);
        pt = (CheckBox) findViewById(R.id.ptCheckBox);
        contract = (CheckBox) findViewById(R.id.contractCheckBox);
        coop = (CheckBox) findViewById(R.id.internCheckBox);

        ref = FirebaseDatabase.getInstance().getReference();

        dateOfBirth();
        startDate();
        salaryOption();
        employment();
    }

    public void dateOfBirth(){
        dofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AccountSetUp.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        dofbirthDateSetListener, year, month, day);
                //set background transparent
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dofbirthDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                dofBirth.setText(date);
            }
        };
    }

    public void startDate(){
        sDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AccountSetUp.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        startDateSetListener, year, month, day);
                //set background transparent
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        startDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                sDate.setText(date);
            }
        };
    }

    //set drop down options for salary
    public  void salaryOption(){
        Spinner salaryOption = (Spinner) findViewById(R.id.salarySpinner);

        ArrayAdapter<String> salaryAdapter = new ArrayAdapter<String>(AccountSetUp.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.salaryType));
        salaryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        salaryOption.setAdapter(salaryAdapter);

        salaryOption.setSelection(1);
    }

    public void employment(){
        ft.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ft.isChecked()){
                    //do something if full time check box is clicked
                }
            }
        });

        pt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(pt.isChecked()){
                    //do something if part check box is clicked
                }
            }
        });

        contract.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(contract.isChecked()){
                    //do something if contract check box is clicked
                }
            }
        });

        coop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(coop.isChecked()){
                    //do something if coop/intern check box is clicked
                }
            }
        });
    }

    public void Next(View v){
        Intent access = new Intent(getApplicationContext(), Access.class);
        startActivity(access);
    }

}
