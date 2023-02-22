package com.example.sharedpreferenced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String username, password;
    KendaliLogin KL = new KendaliLogin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_main_username);
        etPassword = findViewById(R.id.et_main_password);
        btnLogin = findViewById(R.id.btn_main_login);

        btnLogin.setOnClickListener(v -> {
            username = etUsername.getText().toString();
            password = etPassword.getText().toString();

            KL.setPref(MainActivity.this, "spPadang", username);
            startActivity(new Intent(MainActivity.this, Tampil.class));
            finish();

//            if (username.equals("admin") && password.equals("admin")) {
//                KL.setPref(MainActivity.this, "spPadang", username);
//                startActivity(new Intent(MainActivity.this, Tampil.class));
//                finish();
//            }
//            else {
//                Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();;
//            }
        });
    }
}