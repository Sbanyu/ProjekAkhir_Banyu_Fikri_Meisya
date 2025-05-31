package com.example.mobileprogramming;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity {

    LoginActivityBinding binding;
    View view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize
        binding = LoginActivityBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v ->{
            if (binding.etUsername.getText().toString().equals("kelompok2") && binding.etPassword.getText().toString().equals("123456")){
                Intent i = new Intent(this, DashboardActivity.class);
                i.putExtra("kelompok2",binding.etUsername.getText().toString());
                startActivity(i);
            }else {
                Toast.makeText(this,"Username atau password kamu salah nich!!",Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnRegister.setOnClickListener(v ->{
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Konfirmasi");
            dialog.setMessage("Apakah kamu belum mempunyai akun?");
            dialog.setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
            dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            dialog.show();
        });
    }
}
