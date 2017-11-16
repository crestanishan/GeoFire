package com.example.nishan.registrationandlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nishan.registrationandlogin.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextAddress, editTextContacts;
    Button buttonSubmit, buttonSkip;
    Spinner spinnerbloodGroup;

    DatabaseReference databaseUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextContacts = (EditText) findViewById(R.id.editTextContacts);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSkip = (Button) findViewById(R.id.buttonSkipe);
        spinnerbloodGroup = (Spinner) findViewById(R.id.spinner);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submit();

            }
        });

        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class );
                startActivity(intent);
             }
        });

    }

    public void submit(){
    String username = editTextUsername.getText().toString().trim();
    String email = editTextEmail.getText().toString().trim();
    String address = editTextAddress.getText().toString().trim();
    String contacts = editTextContacts.getText().toString().trim();
    String bloodGroup = spinnerbloodGroup.getSelectedItem().toString();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(address) && !TextUtils.isEmpty(contacts) ){

            String id = databaseUsers.push().getKey();

            User user = new User(id, username, email, address, contacts, bloodGroup);

            databaseUsers.child(id).setValue(user);

            Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
        }

    }

}





