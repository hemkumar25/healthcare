package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName , tvTotalCost;
    EditText edDetails;
    Button btnAddToCart, btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextLDMultilines);
        btnAddToCart = findViewById(R.id.buttonLabDAddTo);
        btnBack = findViewById(R.id.buttonLabDBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total cost :"+intent.getStringExtra("text3")+"/-");


    }
}