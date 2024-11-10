package com.example.modul_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.Tuser);
        passwordEditText = findViewById(R.id.Tpass);
        loginButton = findViewById(R.id.BLogin); // Pastikan ID ini sesuai di XML

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Mengambil kredensial dari SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString(KEY_USERNAME, null);
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, null);

        // Validasi kredensial
        if (username.equals(savedUsername) && password.equals(savedPassword)) {
            // Jika Login berhasil, alihkan ke Dashboard
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(login.this, main.class);
            startActivity(intent);
            finish();
        } else {
            // Jika Login gagal
            Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
        }
    }
}
