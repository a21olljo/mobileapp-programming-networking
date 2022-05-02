package com.example.networking;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.ViewHolder> {
    private ArrayList<Mountain> mountains;

    public MountainAdapter(ArrayList<Mountain> mountains) {
    }

    @NonNull
    @Override
    public MountainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MountainAdapter.ViewHolder holder, int position) {
        holder.id.setText(mountains.get(position).getId());
        holder.name.setText(mountains.get(position).getName());
        holder.location.setText(mountains.get(position).getLocation());
        holder.size.setText(mountains.get(position).getSize());
        holder.cost.setText(mountains.get(position).getCost());
        holder.wiki.setText(mountains.get(position).getAuxdata().getWiki());
//      holder.img.setImage(mountains.get(position).getAuxdata().getImg());
        // TODO fix a setImage presumably Picasso lib
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public ArrayList<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(ArrayList<Mountain> mountains) {
        this.mountains = mountains;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, name, location, size, cost, wiki;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);
            size = itemView.findViewById(R.id.size);
            cost = itemView.findViewById(R.id.cost);
            wiki = itemView.findViewById(R.id.wiki);
            img = itemView.findViewById(R.id.img);


        }
    }
}
