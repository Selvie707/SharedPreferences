package com.example.sharedpreferenced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.PublicKey;

public class Tampil extends AppCompatActivity {

    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi;
    private Button btnLogout;
    private String ambilSesi;
    public static String keySPUsername = "spPadang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (KL.isLogin(Tampil.this, keySPUsername) == true) {
            setContentView(R.layout.activity_tampil);

            tvSesi = findViewById(R.id.tv_tampil_username);
            btnLogout = findViewById(R.id.btn_tampil_logout);

            ambilSesi = KL.getPref(Tampil.this, "spPadang");
            tvSesi = findViewById(R.id.tv_tampil_username);
            tvSesi.setText(ambilSesi);

            btnLogout.setOnClickListener(v -> {
                KL.setPref(Tampil.this, "spPadang", null);
                startActivity(new Intent(Tampil.this, MainActivity.class));
                finish();
            });
        }
        else {
            startActivity(new Intent(Tampil.this, MainActivity.class));
            finish();
        }
    }
}