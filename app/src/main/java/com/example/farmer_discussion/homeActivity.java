package com.example.farmer_discussion;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.farmer_discussion.databinding.ActivityHomeBinding;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;


public class homeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    RecyclerView recyclerView;
    DatabaseReference database;
    IssueAdaptor issueAdaptor;
    ArrayList<IssueModal> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        replaceFragments(new homeFragment());
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        binding.bottonNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragments(new homeFragment());
                    break;
                case R.id.settings:
                    replaceFragments(new settingFragment());
                    break;
                case R.id.news:
                    replaceFragments(new newsFragment());
                    break;
                case R.id.post:
                    replaceFragments(new createIssueFragment());
                    break;
                case R.id.search:
                    replaceFragments(new searchFragment());
                    break;
            }
            return true;
        });


//        recyclerView = findViewById(R.id.post_listRV);
//        database = FirebaseDatabase.getInstance().getReference("issues");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        list = new ArrayList<>();
//        issueAdaptor = new IssueAdaptor(this, list);
//        recyclerView.setAdapter(issueAdaptor);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for( DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    IssueModal issueModal = dataSnapshot.getValue(IssueModal.class);
//                    list.add(issueModal);
//                }
//                issueAdaptor.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        Button issueBtn = findViewById(R.id.addissueBtn);
//        issueBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent addIssue = new Intent(homeActivity.this, createIssueActivity.class);
//                startActivity(addIssue);
//            }
//        });
    }
    private void replaceFragments(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

//    public void addPostActivity(View view) {
//        Toast.makeText(homeActivity.this, "clicked Add Issue", Toast.LENGTH_SHORT).show();
//        Intent addIssueIntent = new Intent(homeActivity.this, CreateIssue.class);
//        startActivity(addIssueIntent);
//    }


}