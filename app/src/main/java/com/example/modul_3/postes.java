package com.example.modul_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class postes extends AppCompatActivity {

    private EditText nama;
    private CheckBox status;
    private RadioGroup radioGroup;
    private RadioButton golongan1, golongan2;
    private Button Hitung, Clear;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postes);

        nama = findViewById(R.id.TNama);
        status = findViewById(R.id.CStatus);
        radioGroup = findViewById(R.id.RgGol);
        golongan1 = findViewById(R.id.R1);
        golongan2 = findViewById(R.id.R2);
        Hitung = findViewById(R.id.BtnHitung);
        Clear = findViewById(R.id.BtnClear); // Initialize the Clear button
        resultTextView = findViewById(R.id.THasil);

        Hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kalkulatorpendapatan();
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() { // Clear button functionality
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private void kalkulatorpendapatan() {
        String name = nama.getText().toString();
        boolean menikah = status.isChecked();
        int selectedGolonganId = radioGroup.getCheckedRadioButtonId();

        String golongan;
        if (selectedGolonganId == R.id.R1) {
            golongan = "Golongan 1";
        } else if (selectedGolonganId == R.id.R2) {
            golongan = "Golongan 2";
        } else {
            resultTextView.setText("Tolong isi Golongan.");
            return;
        }

        double pendapatanAwal = golongan.equals("Golongan 1") ? 2000000 : 3000000;
        double Bonus = menikah ? 500000 : 0;
        double totalpendapatan = pendapatanAwal + Bonus;

        String result = "Nama: " + name + "\n"
                + "Status: " + (menikah ? "Menikah" : "Belum Menikah") + "\n"
                + "Golongan: " + golongan + "\n"
                + "Total Pendapatan: Rp " + totalpendapatan;
        resultTextView.setText(result);
    }

    private void clearFields() {
        // Clear all input fields and result
        nama.setText("");
        status.setChecked(false);
        radioGroup.clearCheck();
        resultTextView.setText("");
    }

}
