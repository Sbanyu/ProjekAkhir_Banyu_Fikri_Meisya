package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.databinding.DashboardActivityBinding;

public class DashboardActivity extends AppCompatActivity {

    DashboardActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DashboardActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.cardServer.setOnClickListener(view -> {
            Intent i = new Intent(this,SensorActivity.class);
            startActivity(i);
        });

        binding.cardMaps.setOnClickListener(v -> {
            Intent i = new Intent(this,MapsActivity.class);
            startActivity(i);
        });
    }
}
