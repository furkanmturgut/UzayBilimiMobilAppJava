package com.kunai.uzaybilimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kunai.uzaybilimi.anasayfa.BilgilerActivity;
import com.kunai.uzaybilimi.anasayfa.GezegenlerActivity;
import com.kunai.uzaybilimi.anasayfa.HaberActivity;
import com.kunai.uzaybilimi.anasayfa.RoketActivity;
import com.kunai.uzaybilimi.anasayfa.TrUzayActivity;
import com.kunai.uzaybilimi.anasayfa.VideolarActivity;

import java.util.zip.Inflater;

public class AnasayfaActivity extends AppCompatActivity {
    CardView cardGezegen,cardRoket,cardVideo,cardHaber,cardBilgi,cardTr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        init();
        cardGezegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, GezegenlerActivity.class);
                startActivity(intent);
            }
        });

        cardRoket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, RoketActivity.class);
                startActivity(intent);
            }
        });

        cardVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, VideolarActivity.class);
                startActivity(intent);
            }
        });

        cardBilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, BilgilerActivity.class);
                startActivity(intent);
            }
        });

        cardHaber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, HaberActivity.class);
                startActivity(intent);
            }
        });

        cardTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnasayfaActivity.this, TrUzayActivity.class);
                startActivity(intent);
            }
        });


    }

    private void init() {

    cardGezegen = findViewById(R.id.cardGezegen);
    cardRoket = findViewById(R.id.cardRoket);
    cardVideo = findViewById(R.id.cardVideo);
    cardHaber = findViewById(R.id.cardHaber);
    cardBilgi = findViewById(R.id.cardBilgi);
    cardTr = findViewById(R.id.cardTr);

    }
}