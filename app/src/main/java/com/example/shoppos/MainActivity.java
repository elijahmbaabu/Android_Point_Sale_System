package com.example.shoppos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private String phone;
    private String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, User_Registration.class));
            }
        });

        binding.userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                phone = binding.inputPhone.getText().toString();
                pass = binding.password.getText().toString();

                if (pass.isEmpty() && phone.isEmpty()){
                    binding.inputPhone.setError("Phone Number Required");
                    binding.password.setError("Password Required");
                }
                 else if (phone.isEmpty()){
                     binding.inputPhone.setError("Phone Number Required");
                }
                 else if (pass.isEmpty()){
                    binding.password.setError("Password Required");
                }
                 else {
                     LoginUser();
                }

            }
        });
    }

    private void LoginUser() {

    }
}