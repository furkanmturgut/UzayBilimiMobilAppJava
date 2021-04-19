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

public class HaberActivity extends AppCompatActivity {
    RecyclerView recyclerViewHaber;
    ImageView geriHaber;
    FirebaseFirestore firebaseFirestore;
    HaberAdapter haberAdapter;
    ArrayList<String> haberBaslikList;
    ArrayList<String> haberlerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haber);

        init();
        haberBaslikList = new ArrayList<>();
        haberlerList = new ArrayList<>();
        haberAdapter = new HaberAdapter(haberBaslikList,haberlerList);
        recyclerViewHaber.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHaber.setAdapter(haberAdapter);
        haberCek();
        geriHaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HaberActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        geriHaber = findViewById(R.id.geriHaber);
        recyclerViewHaber = findViewById(R.id.recyclerViewHaber);
    }

    public void haberCek(){
        CollectionReference collectionReference = firebaseFirestore.collection("Haberler");
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value !=null){
                    for (DocumentSnapshot documentSnapshot: value.getDocuments()){
                        Map<String,Object> map = documentSnapshot.getData();
                        String baslik = (String) map.get("baslik");
                        String haber = (String) map.get("haber");

                        haberBaslikList.add(baslik);
                        haberlerList.add(haber);

                        haberAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}