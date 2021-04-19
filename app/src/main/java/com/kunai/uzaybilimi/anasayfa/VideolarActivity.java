package com.kunai.uzaybilimi.anasayfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.kunai.uzaybilimi.AnasayfaActivity;
import com.kunai.uzaybilimi.R;

public class VideolarActivity extends AppCompatActivity {

    ImageView geriVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolar);

        geriVideo = findViewById(R.id.geriVideo);
        geriVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideolarActivity.this, AnasayfaActivity.class);
                startActivity(intent);
            }
        });
    }
}