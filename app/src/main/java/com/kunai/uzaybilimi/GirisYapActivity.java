package com.kunai.uzaybilimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GirisYapActivity extends AppCompatActivity {
    EditText editTextMailGiris,editTextSifreGiris;
    TextView textGirisYap;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_yap);

        init();

        textGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GirisYapActivity.this,KaydolActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        editTextMailGiris = findViewById(R.id.editTextMailGiris);
        editTextSifreGiris = findViewById(R.id.editTextSifreGiris);
        textGirisYap = findViewById(R.id.textGirisYap);
    }

    public void girisYap(View view){
        String mail = editTextMailGiris.getText().toString();
        String pass = editTextSifreGiris.getText().toString();
        
        firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(GirisYapActivity.this,AnasayfaActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(GirisYapActivity.this, "Hata!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}