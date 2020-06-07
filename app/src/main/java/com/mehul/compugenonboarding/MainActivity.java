package com.mehul.compugenonboarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button button;
    ProgressBar progress;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.usernameEditText);
        password = (EditText)findViewById(R.id.passwordEditText);
        button = (Button)findViewById(R.id.button);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }

    public void getStarted(View v){

        button.setVisibility(View.INVISIBLE);
        progress.setVisibility(View.VISIBLE);


        if (!validateForm()) {
            Toast.makeText(MainActivity.this, "Username and password is required",
                    Toast.LENGTH_SHORT).show();

            button.setVisibility(View.VISIBLE);
            progress.setVisibility(View.INVISIBLE);

            return;
        }

        try {
                mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        button.setVisibility(View.INVISIBLE);
                                        progress.setVisibility(View.VISIBLE);

                                        // Sign in success, update UI with the signed-in user's information
                                        Log.i("signInWithEmail:", "success");
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Intent accountSetup = new Intent(getApplicationContext(), AccountSetUp.class);
                                        startActivity(accountSetup);
                                    } else {
                                        button.setVisibility(View.VISIBLE);
                                        progress.setVisibility(View.INVISIBLE);

                                        // If sign in fails, display a message to the user.
                                        Log.i("signInWithEmail:", "failure: " + task.getException());
                                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();


                                    }
                            }
                        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //validateForm boolean method to validate if fields are entered
    private boolean validateForm() {
        boolean valid = true;
        String susername = username.getText().toString();
        String spassword = password.getText().toString();

        if (susername.isEmpty()) {
            valid = false;
        }

        if (spassword.isEmpty()) {
            valid = false;
        }

        return valid;
    }

}
