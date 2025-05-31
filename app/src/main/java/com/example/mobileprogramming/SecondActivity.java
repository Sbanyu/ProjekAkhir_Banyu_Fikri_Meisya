package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.databinding.MainActivityBinding;
import com.example.mobileprogramming.databinding.RegisterActivityBinding;

public class SecondActivity extends AppCompatActivity {


    MainActivityBinding binding;
    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainActivityBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(binding.getRoot());

        String getNama;
        Intent intent = getIntent();
        getNama = intent.getStringExtra("kelompok2");


        binding.label.setText("Selamat Datang" + " " + getNama);
    }
}
