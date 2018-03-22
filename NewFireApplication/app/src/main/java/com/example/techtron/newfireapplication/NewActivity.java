package com.example.techtron.newfireapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class NewActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        storageReference = FirebaseStorage.getInstance().getReference();
    }

    public void signOut(View v){
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();

        startActivity(new Intent(NewActivity.this, MainActivity.class));
    }

    void imageUploadClicked(){

    }
}
