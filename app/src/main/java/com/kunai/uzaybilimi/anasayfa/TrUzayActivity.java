package com.kunai.uzaybilimi.anasayfa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.kunai.uzaybilimi.AnasayfaActivity;
import com.kunai.uzaybilimi.R;
import com.kunai.uzaybilimi.adapter.HaberAdapter;

import java.util.ArrayList;
import java.util.Map;

public class TrUzayActivity extends AppCompatActivity {
    ImageView geriTr;
    RecyclerView recyclerViewTr;
    FirebaseFirestore firebaseFirestore;
    HaberAdapter haberAdapter;
    ArrayList<String> haberBaslikList;
    ArrayList<String> haberlerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr_uzay);

        init();
        geriTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrUzayActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });

        haberBaslikList = new ArrayList<>();
        haberlerList = new ArrayList<>();
        haberAdapter = new HaberAdapter(haberBaslikList,haberlerList);
        veriCek();
        recyclerViewTr.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTr.setAdapter(haberAdapter);


    }

    private void init() {

    geriTr = findViewById(R.id.geriTr);
    recyclerViewTr = findViewById(R.id.recyclerViewTr);
    firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public void veriCek(){
        CollectionReference collectionReference = firebaseFirestore.collection("Tr Uzay");
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (value !=null){
                    for (DocumentSnapshot documentSnapshot: value.getDocuments()){
                        Map<String,Object> map = documentSnapshot.getData();
                        String haber = (String) map.get("haber");
                        String baslik = (String) map.get("baslik");

                        haberBaslikList.add(baslik);
                        haberlerList.add(haber);

                        haberAdapter.notifyDataSetChanged();
                    }
                }


            }
        });

    }
}