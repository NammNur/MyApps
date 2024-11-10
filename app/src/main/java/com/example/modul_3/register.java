package com.example.modul_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {


    private EditText email;
    private EditText ussername;
    private EditText password;
    private Button registerButton;

    private static final String PREFS_NAMA = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        ussername = findViewById(R.id.Tuser);
        password = findViewById(R.id.Tpass);
        registerButton = findViewById(R.id.BRegis);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String email = this.email.getText().toString().trim();
        String username = ussername.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        saveCredentials(username, password);
        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(register.this, login.class);
        startActivity(intent);
        finish();
    }

    private void saveCredentials(String username, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAMA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }
}
