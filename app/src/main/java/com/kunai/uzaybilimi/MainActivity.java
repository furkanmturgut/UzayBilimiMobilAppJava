package com.kunai.uzaybilimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.kunai.uzaybilimi.anasayfa.GezegenlerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(MainActivity.this,KaydolActivity.class);
              startActivity(intent);
          }
      },4000);
    }
}