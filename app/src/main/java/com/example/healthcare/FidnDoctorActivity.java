package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FidnDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fidn_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FidnDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView familyphysian = findViewById(R.id.cardFDfamilyPhysician);
        familyphysian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FidnDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","familyphysician");
                startActivity(it);
            }
        });
        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FidnDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title", "Dietician");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
       dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FidnDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });

        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FidnDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

        CardView cardiologist = findViewById(R.id.cardFDCardiologist);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FidnDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);
            }
        });
    }
}