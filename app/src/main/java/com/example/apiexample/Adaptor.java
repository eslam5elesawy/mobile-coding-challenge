package com.example.apiexample;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.ViewHolder>{

    List<item> list ;
    Context context ;

    public Adaptor(List<item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_example ,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item item = list.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.ownerName.setText(item.getOwner().getFull_name());
        holder.stars.setText(item.getStargazers_count());
        Glide.with(context).load(item.getOwner().getAvatar_url()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView description;
        public TextView ownerName;
        public TextView stars;
        public ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.repository_name);
            description = itemView.findViewById(R.id.repository_description);
            ownerName = itemView.findViewById(R.id.owner_name);
            stars = itemView.findViewById(R.id.Stars);
            avatar = itemView.findViewById(R.id.owner_avatar);
        }
    }
}
