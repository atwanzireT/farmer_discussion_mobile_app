package com.example.farmer_discussion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IssueAdaptor extends RecyclerView.Adapter<IssueAdaptor.MyViewHolder> {
    Context context;
    ArrayList<IssueModal> list;

    public IssueAdaptor(Context context, ArrayList<IssueModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.text_card, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IssueModal issueModal = list.get(position);
        holder.title.setText(issueModal.title);
        holder.detail.setText(issueModal.detail);
        holder.author.setText(issueModal.author);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title, detail, author;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textCardTitle);
            detail = itemView.findViewById(R.id.textCardBody);
            author = itemView.findViewById(R.id.textcard_username);
        }
    }
}
