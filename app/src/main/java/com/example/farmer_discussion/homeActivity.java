package com.example.farmer_discussion;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class homeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    IssueAdaptor issueAdaptor;
    ArrayList<IssueModal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.post_listRV);
        database = FirebaseDatabase.getInstance().getReference("issues");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        issueAdaptor = new IssueAdaptor(this, list);
        recyclerView.setAdapter(issueAdaptor);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    IssueModal issueModal = dataSnapshot.getValue(IssueModal.class);
                    list.add(issueModal);
                }
                issueAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Button issueBtn = findViewById(R.id.addissueBtn);
        issueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIssue = new Intent(homeActivity.this, createIssueActivity.class);
                startActivity(addIssue);
            }
        });
    }

//    public void addPostActivity(View view) {
//        Toast.makeText(homeActivity.this, "clicked Add Issue", Toast.LENGTH_SHORT).show();
//        Intent addIssueIntent = new Intent(homeActivity.this, CreateIssue.class);
//        startActivity(addIssueIntent);
//    }


}