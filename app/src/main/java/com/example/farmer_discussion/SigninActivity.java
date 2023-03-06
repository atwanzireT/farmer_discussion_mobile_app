package com.example.farmer_discussion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void haveAccountFunc(View view) {
        Intent haveAccountIntent = new Intent(SigninActivity.this, loginActivity.class);
        startActivity(haveAccountIntent);
    }

    public void signupFunc(View view) {
        EditText emailField, passwordField;
        ProgressBar bar;
        FirebaseAuth mAuth;

        emailField = findViewById(R.id.email_loginField);
        passwordField = findViewById(R.id.pwd_loginField);
        bar = findViewById(R.id.signinProgressBar);

        bar.setVisibility(View.VISIBLE);
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            bar.setVisibility(view.INVISIBLE);
                            emailField.setText("");
                            passwordField.setText("");
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            bar.setVisibility(View.INVISIBLE);
                            emailField.setText("");
                            passwordField.setText("");
                            Toast.makeText(getApplicationContext(), "Process Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}