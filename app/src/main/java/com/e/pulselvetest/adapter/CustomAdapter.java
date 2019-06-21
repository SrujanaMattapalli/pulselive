package com.e.pulselvetest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.pulselvetest.R;
import com.e.pulselvetest.model.Item;
import com.e.pulselvetest.view.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<Item> list = new ArrayList<>();
    public CustomAdapter(Context context, List<Item> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, final int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvSubTitle.setText(list.get(position).getSubtitle());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent details = new Intent(context, DetailsActivity.class);
                details.putExtra("_id",list.get(position).getId().toString());
                details.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(details);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubTitle;
        ConstraintLayout parentLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.tvFname);
            tvSubTitle = (TextView)itemView.findViewById(R.id.tvLname);
            parentLayout = (ConstraintLayout)itemView.findViewById(R.id.parentLayout);
        }
    }
}