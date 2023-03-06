package com.example.farmer_discussion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signUpFunctionality(View view) {
        Intent homeIntent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(homeIntent);
    }
}