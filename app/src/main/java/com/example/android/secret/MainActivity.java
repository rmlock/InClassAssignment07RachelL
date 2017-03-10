package com.example.android.secret;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveSecret(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        EditText named = (EditText) findViewById(R.id.name);
        String name = named.getText().toString();

        DatabaseReference myRef = database.getReference(name).child("secret");

        myRef.setValue("Hello, World!");
        myRef.setValue("message");
        EditText editText = (EditText) findViewById(R.id.secretEntered);
        String secret = editText.getText().toString();

        Toast.makeText(this, "Secret Saved!", Toast.LENGTH_SHORT).show();
        myRef.setValue(secret);

    }

    public void revealSecret(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);



    }
}
