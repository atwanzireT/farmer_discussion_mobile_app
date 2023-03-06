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

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginFunc(View view) {
        EditText emailField, passwordField;
        ProgressBar bar;
        FirebaseAuth mAuth;
        emailField = findViewById(R.id.email_loginField);
        passwordField = findViewById(R.id.pwd_loginField);
        bar = findViewById(R.id.loginProgressBar);
        mAuth = FirebaseAuth.getInstance();

        bar.setVisibility(View.VISIBLE);
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    bar.setVisibility(View.INVISIBLE);
                    Intent loginIntent = new Intent(loginActivity.this, homeActivity.class);
                    loginIntent.putExtra("email", mAuth.getCurrentUser().getEmail());
                    loginIntent.putExtra("uid", mAuth.getCurrentUser().getUid());
                    startActivity(loginIntent);
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

    public void dontHaveAccFunc(View view) {
        Intent dontHaveAccIntent = new Intent(loginActivity.this, SigninActivity.class);
        startActivity(dontHaveAccIntent);
    }

}