package com.kunai.uzaybilimi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kunai.uzaybilimi.R;

import java.util.ArrayList;

public class GezegenBilgiAdapter extends RecyclerView.Adapter<GezegenBilgiAdapter.GbilgiHolder> {
    ArrayList<String> gezegenAdiList;
    ArrayList<String> gezegenBigliList;

    public GezegenBilgiAdapter(ArrayList<String> gezegenAdiList, ArrayList<String> gezegenBigliList) {
        this.gezegenAdiList = gezegenAdiList;
        this.gezegenBigliList = gezegenBigliList;
    }

    @NonNull
    @Override
    public GezegenBilgiAdapter.GbilgiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rcgezegenbilgi,parent,false);

        return new GbilgiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GezegenBilgiAdapter.GbilgiHolder holder, int position) {
            holder.textGezegenAdi.setText(gezegenAdiList.get(position));
            holder.textGezegenBilgi.setText(gezegenBigliList.get(position));
    }

    @Override
    public int getItemCount() {
        return gezegenAdiList.size();
    }

    public class GbilgiHolder extends RecyclerView.ViewHolder {
        TextView textGezegenAdi,textGezegenBilgi;
        public GbilgiHolder(@NonNull View itemView) {
            super(itemView);
            textGezegenAdi = itemView.findViewById(R.id.textGezegenAdi);
            textGezegenBilgi = itemView.findViewById(R.id.textGezegenBilgi);
        }
    }
}
