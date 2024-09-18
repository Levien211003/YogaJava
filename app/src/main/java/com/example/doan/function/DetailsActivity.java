package com.example.doan.function;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doan.R;

public class DetailsActivity extends AppCompatActivity {

    TextView tvDetailC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvDetailC= findViewById(R.id.tvDetail);

        String id = getIntent().getStringExtra("userId");
        tvDetailC.setText(id);

    }
}