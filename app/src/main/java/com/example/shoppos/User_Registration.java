package com.example.shoppos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.shoppos.databinding.ActivityUserRegistrationBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class User_Registration extends AppCompatActivity {

 private ActivityUserRegistrationBinding userRegistrationBinding;
 
 private String shopName;
 private String userPhone;
 private String userPassword;
 private String confirmPassword;
DatabaseReference reference;
 FirebaseAuth firebaseAuth;
 FirebaseFirestore firebaseFirestore;
 FirebaseStorage firebaseStorage;
 FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        userRegistrationBinding = ActivityUserRegistrationBinding.inflate(getLayoutInflater());
        View view = userRegistrationBinding.getRoot();
        setContentView(view);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        
        
        
        userRegistrationBinding.userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userPhone = userRegistrationBinding.inputPhone.getText().toString();
                shopName = userRegistrationBinding.ShopName.getText().toString();
                userPassword = userRegistrationBinding.setPassword.getText().toString();
                confirmPassword = userRegistrationBinding.confirmPass.getText().toString();

                if (userPassword.isEmpty() && shopName.isEmpty() && userPassword.isEmpty() && confirmPassword.isEmpty()) {
                    userRegistrationBinding.inputPhone.setError("Phone Number Required");
                    userRegistrationBinding.ShopName.setError("Shop Name Required");
                    userRegistrationBinding.setPassword.setError("Password Required");
                    userRegistrationBinding.confirmPass.setError("Password Confirmation Required");
                }
                else if (userPhone.isEmpty()){
                    userRegistrationBinding.inputPhone.setError("Phone Number Required");
                }
                else if (shopName.isEmpty()){
                    userRegistrationBinding.ShopName.setError("Shop Name Required");
                }
                else if (userPassword.isEmpty()){
                    userRegistrationBinding.setPassword.setError("Password Required");
                }
                else if (confirmPassword.isEmpty()){
                    userRegistrationBinding.confirmPass.setError("Password Confirmation Required");
                }
                else if (!userPassword.equals(confirmPassword)){
                    userRegistrationBinding.confirmPass.setError("Password and Confirm password do not match");
                }
                else {
                    SaveUserDetails();
                }
            }
  
        });
    }

    private void SaveUserDetails() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Registered Shops").child(shopName);

        ShopDetails shopDetails = new ShopDetails(userPhone, shopName, userPassword);

        reference.setValue(shopDetails);
    }
}