package com.example.techtron.newfireapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextPassword;
    private String email, password;
    public Button buttonRegister;
    public AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendRegistration();
                    }
                }
        );

    }

    private void sendRegistration() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();

        if (email.length() < 1 ) {
            Toast.makeText(this, "About to check value", Toast.LENGTH_SHORT).show();
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Email Error:");
            alertDialog.setMessage("Please Enter an Email Address");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else if (password.length() < 1 ) {
            Toast.makeText(this, "About to check value", Toast.LENGTH_SHORT).show();
            alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Password Error:");
            alertDialog.setMessage("Please Enter an Password");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        else{

            Toast.makeText(this, email, Toast.LENGTH_SHORT).show();

        }
    }
}
