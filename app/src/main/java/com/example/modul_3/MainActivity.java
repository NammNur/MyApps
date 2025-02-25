package com.example.modul_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void openlogin(View view) {
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }
    public void openregister(View view) {
        Intent intent = new Intent(MainActivity.this, register.class);
        startActivity(intent);
    }
}