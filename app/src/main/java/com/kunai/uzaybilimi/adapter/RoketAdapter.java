package com.kunai.uzaybilimi.adapter;


import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kunai.uzaybilimi.R;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class RoketAdapter extends RecyclerView.Adapter<RoketAdapter.RoketBilgiHolder> {
    ArrayList<String> roketAdiList;
    ArrayList<String> roketFirmaList;
    ArrayList<String> roketMenseiList;
    ArrayList<String> roketMaliyetList;
    ArrayList<String> roketUcusList;


    public RoketAdapter(ArrayList<String> roketAdiList, ArrayList<String> roketFirmaList, ArrayList<String> roketMenseiList, ArrayList<String> roketMaliyetList, ArrayList<String> roketUcusList ) {
        this.roketAdiList = roketAdiList;
        this.roketFirmaList = roketFirmaList;
        this.roketMenseiList = roketMenseiList;
        this.roketMaliyetList = roketMaliyetList;
        this.roketUcusList = roketUcusList;

    }

    @NonNull
    @Override
    public RoketAdapter.RoketBilgiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rvroket,parent,false);

        return new RoketBilgiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoketAdapter.RoketBilgiHolder holder, int position) {
        holder.roketAdi.setText("Adı: "+roketAdiList.get(position));
        holder.roketFirma.setText("Firma: "+roketFirmaList.get(position));
        holder.roketMensei.setText("Menşei: "+roketMenseiList.get(position));
        holder.roketMaliyet.setText("Maliyeti: "+roketMaliyetList.get(position));
        holder.roketUcus.setText("İlk Uçus: "+roketUcusList.get(position));
    }

    @Override
    public int getItemCount() {
        return roketAdiList.size();
    }

    public class RoketBilgiHolder extends RecyclerView.ViewHolder {
        TextView roketAdi,roketFirma,roketMensei,roketMaliyet,roketUcus;
        ImageView roketResim;
        public RoketBilgiHolder(@NonNull View itemView) {
            super(itemView);
            roketAdi = itemView.findViewById(R.id.roketAdi);
            roketFirma = itemView.findViewById(R.id.roketFirma);
            roketMensei = itemView.findViewById(R.id.roketMensei);
            roketMaliyet = itemView.findViewById(R.id.roketMaliyet);
            roketUcus = itemView.findViewById(R.id.roketUcus);
            roketResim = itemView.findViewById(R.id.roketResim);

        }
        }
    }

