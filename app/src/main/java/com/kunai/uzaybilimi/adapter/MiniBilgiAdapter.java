package com.kunai.uzaybilimi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kunai.uzaybilimi.R;

import java.util.ArrayList;

public class MiniBilgiAdapter extends RecyclerView.Adapter<MiniBilgiAdapter.BilgilerHolder> {
    ArrayList<String> bilgiList;

    public MiniBilgiAdapter(ArrayList<String> bilgiList){
        this.bilgiList = bilgiList;
    }

    @NonNull
    @Override
    public MiniBilgiAdapter.BilgilerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rvbilgiler,parent,false);
        return new BilgilerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiniBilgiAdapter.BilgilerHolder holder, int position) {
        holder.textBilgiler.setText(bilgiList.get(position));
    }

    @Override
    public int getItemCount() {
        return bilgiList.size();
    }

    public class BilgilerHolder extends RecyclerView.ViewHolder {
        TextView textBilgiler;
        public BilgilerHolder(@NonNull View itemView) {
            super(itemView);
            textBilgiler = itemView.findViewById(R.id.textBilgiler);
        }
    }
}
