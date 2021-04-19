package com.kunai.uzaybilimi.anasayfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.kunai.uzaybilimi.R;

public class GezegenBilgiActivity extends AppCompatActivity {
    ImageView geriGezegenBilgi;
    RecyclerView recyclerViewGezegenBilgi;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezegen_bilgi);

        geriGezegenBilgi = findViewById(R.id.geriGezegenBilgi);
        recyclerViewGezegenBilgi = findViewById(R.id.recyclerViewGezegen);
        firebaseFirestore = FirebaseFirestore.getInstance();


    }
}