package com.kunai.uzaybilimi.anasayfa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.kunai.uzaybilimi.AnasayfaActivity;
import com.kunai.uzaybilimi.R;
import com.kunai.uzaybilimi.adapter.RoketAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoketActivity extends AppCompatActivity {
    RecyclerView recyclerViewRoket;
    ImageView geriRoket;
    FirebaseFirestore firebaseFirestore;
    RoketAdapter roketAdapter;

    ArrayList<String> roketAdiList;
    ArrayList<String> roketFirmaList;
    ArrayList<String> roketMenseiList;
    ArrayList<String> roketMaliyetList;
    ArrayList<String> roketUcusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roket);

        roketAdiList = new ArrayList<>();
        roketFirmaList = new ArrayList<>();
        roketMenseiList = new ArrayList<>();
        roketMaliyetList = new ArrayList<>();
        roketUcusList = new ArrayList<>();

        init();
        roketAdapter = new RoketAdapter(roketAdiList,roketFirmaList,roketMenseiList,roketMaliyetList,roketUcusList);
        recyclerViewRoket.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRoket.setAdapter(roketAdapter);

        roketVeriCekme();

        geriRoket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RoketActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        recyclerViewRoket = findViewById(R.id.recyclerViewRoket);
        geriRoket = findViewById(R.id.geriRoket);
        firebaseFirestore = FirebaseFirestore.getInstance();




    }

    public void roketVeriCekme(){
        CollectionReference collectionReference = firebaseFirestore.collection("Roket Bilgiler");
        collectionReference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value!=null){
                    for (DocumentSnapshot documentSnapshot : value.getDocuments()){
                        Map<String,Object> map = documentSnapshot.getData();
                        String adi = (String) map.get("adi");
                        String firma = (String) map.get("firma");
                        String mensei = (String) map.get("mensei");
                        String maliyet = (String) map.get("maliyet");
                        String ucus = (String) map.get("ucus");


                        roketAdiList.add(adi);
                        roketFirmaList.add(firma);
                        roketMenseiList.add(mensei);
                        roketMaliyetList.add(maliyet);
                        roketUcusList.add(ucus);

                        roketAdapter.notifyDataSetChanged();

                    }
                }
            }
        });

    }
}