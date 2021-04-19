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
import com.kunai.uzaybilimi.adapter.MiniBilgiAdapter;

import java.util.ArrayList;
import java.util.Map;

public class BilgilerActivity extends AppCompatActivity {
    ImageView geriBilgi;
    RecyclerView recyclerViewBilgiler;
    FirebaseFirestore firebaseFirestore;
    MiniBilgiAdapter miniBilgiAdapter;
    ArrayList<String> bilgilerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);

        init();
        geriBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BilgilerActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });
        bilgilerList = new ArrayList<>();
        miniBilgiAdapter = new MiniBilgiAdapter(bilgilerList);
        recyclerViewBilgiler.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBilgiler.setAdapter(miniBilgiAdapter);
        bilgiCek();
    }

    private void init() {
        firebaseFirestore = FirebaseFirestore.getInstance();
        geriBilgi = findViewById(R.id.geriBilgi);
        recyclerViewBilgiler = findViewById(R.id.recyclerViewBilgi);

    }

    public void bilgiCek(){
        CollectionReference collectionReference = firebaseFirestore.collection("Mini Bilgi");
        collectionReference.orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value!=null){
                    for (DocumentSnapshot snapshot:value.getDocuments()){
                        Map<String,Object> map = snapshot.getData();
                        String bilgi = (String) map.get("bilgi");

                        bilgilerList.add(bilgi);
                        miniBilgiAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}