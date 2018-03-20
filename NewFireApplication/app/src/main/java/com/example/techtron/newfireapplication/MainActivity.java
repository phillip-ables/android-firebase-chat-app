package com.example.techtron.newfireapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrieve an instance of your database using getInstance()
        // and reference the location you want to write to.
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("MyMessage");
    }

    public void sendMessage(View view){
        EditText editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        String message = editTextMessage.getText().toString();

        myRef.setValue(message);
    }
}
