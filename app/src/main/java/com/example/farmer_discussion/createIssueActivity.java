package com.example.farmer_discussion;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createIssueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        submitBtn = (Button) findViewById(R.id.sendIssueBtn);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_issue);

//        submitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(createIssueActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
////                String title = titleField.getText().toString();
////                String detail = detailField.getText().toString();
////                String author = authorField.getText().toString();
//
////                if (TextUtils.isEmpty(title) && TextUtils.isEmpty(detail) && TextUtils.isEmpty(author)) {
////                    // if the text fields are empty
////                    // then show the below message.
////                    Toast.makeText(createIssueActivity.this, "Please Fill in the missing data.", Toast.LENGTH_SHORT).show();
////                } else {
////                    // else call the method to add
////                    // data to our database.
////                    IssueModal issueModal = new IssueModal(title, detail, author);
////                    myRef.child(title).setValue(issueModal).addOnCompleteListener(new OnCompleteListener<Void>() {
////                        @Override
////                        public void onComplete(@NonNull Task<Void> task) {
////                            Toast.makeText(createIssueActivity.this, "Record Added Successfully", Toast.LENGTH_SHORT).show();
////                        }
////                    });
////                }
//            }
//        });

    }

    public void sendIssueFunc(View view) {
        EditText titleField, detailField, authorField;
        Button submitBtn;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("issues");

        titleField = findViewById(R.id.titleField);
        detailField = findViewById(R.id.detailField);
        authorField = findViewById(R.id.authorField);


        String title = titleField.getText().toString();
        String detail = detailField.getText().toString();
        String author = authorField.getText().toString();

        if (TextUtils.isEmpty(title) && TextUtils.isEmpty(detail) && TextUtils.isEmpty(author)) {
            // if the text fields are empty
            // then show the below message.
            Toast.makeText(createIssueActivity.this, "Please Fill in the missing data.", Toast.LENGTH_SHORT).show();
        } else {
            // else call the method to add
            // data to our database.
            IssueModal issueModal = new IssueModal(title, detail, author);
            myRef.child(title).setValue(issueModal).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(createIssueActivity.this, "Record Added Successfully", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}