package com.example.techtron.newfireapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("User");


    }

    public void sendMessage(View view){
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextContact = (EditText) findViewById(R.id.editTextContact);
        myRef = database.getReference();

        myRef.child("Name").setValue(editTextName.getText().toString());
        myRef.child("Contact").setValue(editTextContact.getText().toString());
    }
}
