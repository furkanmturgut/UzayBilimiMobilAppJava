package com.kunai.uzaybilimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class KaydolActivity extends AppCompatActivity {
    EditText editTextMail,editTextSifre;
    TextView textGirisYap;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    Boolean mailKontrol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        init();
        textGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KaydolActivity.this,GirisYapActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        textGirisYap = findViewById(R.id.textGirisYap);
        editTextMail = findViewById(R.id.editTextMail);
        editTextSifre = findViewById(R.id.editTextSifre);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

    }

    public void kayitOl(View view){
        final String mail = editTextMail.getText().toString();
        final String pass = editTextSifre.getText().toString();
        mailKontrol = mail.contains("@");
        mailKontrol = mail.contains(".com");

        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
            Snackbar snackBar = Snackbar.make(view,"Tüm alanları doldurunuz", BaseTransientBottomBar.LENGTH_LONG);
            snackBar.show();
        }else if (pass.length() < 6) {
            Snackbar snackBar = Snackbar.make(view,"En az 6 karater giriniz", BaseTransientBottomBar.LENGTH_LONG);
            snackBar.show();
        }else if (mailKontrol != true){
            Snackbar snackBar = Snackbar.make(view,"Geçerli mail adresi giriniz.", BaseTransientBottomBar.LENGTH_LONG);
            snackBar.show();
        }else {
            firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    String UID = firebaseAuth.getUid();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("mail", mail);
                    hashMap.put("pass",pass);
                    hashMap.put("id",UID);
                    DocumentReference documentReference = firebaseFirestore.collection("Kullanicilar").document(UID);
                    documentReference.set(hashMap);

                    Intent intent = new Intent(KaydolActivity.this,AnasayfaActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(KaydolActivity.this, "HATA!", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}