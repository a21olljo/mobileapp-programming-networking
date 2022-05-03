package com.example.networking;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.ViewHolder> {
    private ArrayList<Mountain> mountains;

    public MountainAdapter(ArrayList<Mountain> mountains) {
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mountain_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MountainAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(mountains.get(position).getName());
        holder.location.setText(mountains.get(position).getLocation());
        holder.size.setText(mountains.get(position).getSize());
        holder.cost.setText(mountains.get(position).getCost());
        holder.wiki.setText(mountains.get(position).getAuxdata().getWiki());
        Picasso.get().load(mountains.get(position).getAuxdata().getImg()).into(holder.img);
        Picasso.get()
            .load(mountains.get(position).getAuxdata().getImg())
            .into(holder.img, new Callback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onError(Exception e) {
                    Picasso.get().load("https://i.ibb.co/wC7Q8zm/Untitled.png").into(holder.img);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public ArrayList<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(ArrayList<Mountain> mountains) {
        this.mountains = mountains;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, size, cost, wiki;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);
            size = itemView.findViewById(R.id.size);
            cost = itemView.findViewById(R.id.cost);
            wiki = itemView.findViewById(R.id.wiki);
            img = itemView.findViewById(R.id.img);


        }
    }
}
