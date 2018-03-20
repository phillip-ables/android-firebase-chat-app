package com.example.techtron.newfireapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrieve an instance of your database using getInstance()
        // and reference the location you want to write to.
        database = FirebaseDatabase.getInstance();

    }

    public void sendMessage(View view){
        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        myRef = database.getReference("Users");
        myRef.child("Name").push().setValue(editTextName.getText().toString());
    }
}
