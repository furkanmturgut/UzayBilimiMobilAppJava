package com.kunai.uzaybilimi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kunai.uzaybilimi.R;

import java.util.ArrayList;

public class HaberAdapter extends RecyclerView.Adapter<HaberAdapter.HaberlerHolder> {
    ArrayList<String> haberBaslikList;
    ArrayList<String> haberlerList;

    public HaberAdapter(ArrayList<String> haberBaslikList, ArrayList<String> haberlerList) {
        this.haberBaslikList = haberBaslikList;
        this.haberlerList = haberlerList;
    }

    @NonNull
    @Override
    public HaberAdapter.HaberlerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rvhaberler,parent,false);

        return new HaberlerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HaberAdapter.HaberlerHolder holder, int position) {
        holder.textHaberBaslik.setText(haberBaslikList.get(position));
        holder.textHaberler.setText(haberlerList.get(position));
    }

    @Override
    public int getItemCount() {
        return haberBaslikList.size();
    }

    public class HaberlerHolder extends RecyclerView.ViewHolder {
        TextView textHaberler,textHaberBaslik;
        public HaberlerHolder(@NonNull View itemView) {
            super(itemView);
            textHaberBaslik = itemView.findViewById(R.id.textHaberBaslik);
            textHaberler = itemView.findViewById(R.id.textHaberler);
        }
    }
}
