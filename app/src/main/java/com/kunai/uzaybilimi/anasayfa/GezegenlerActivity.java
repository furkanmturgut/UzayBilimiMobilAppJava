package com.kunai.uzaybilimi.anasayfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.kunai.uzaybilimi.AnasayfaActivity;
import com.kunai.uzaybilimi.R;

public class GezegenlerActivity extends AppCompatActivity {
    ImageView geriGezegen;
    CardView cardDunya,cardNeptun,cardJupiter,cardMars,cardUranus,cardSaturn,cardMerkur,cardVenus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezegenler);

        init();
        geriGezegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GezegenlerActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });

        cardDunya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GezegenlerActivity.this,GezegenBilgiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        geriGezegen = findViewById(R.id.geriGezegen);
        cardDunya = findViewById(R.id.cardDunya);
        cardNeptun = findViewById(R.id.cardNeptun);
        cardJupiter = findViewById(R.id.cardJupiter);
        cardMars = findViewById(R.id.cardMars);
        cardUranus = findViewById(R.id.cardUranus);
        cardSaturn = findViewById(R.id.cardSaturn);
        cardMerkur = findViewById(R.id.cardMerkur);
        cardVenus = findViewById(R.id.cardVenus);

    }
}