package com.example.android.secret;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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
        DatabaseReference myRef = database.getReference("secret");

        myRef.setValue("Hello, World!");
        myRef.setValue("message");
        EditText editText = (EditText) findViewById(R.id.secretEntered);
        String secret = editText.getText().toString();
        myRef.setValue(secret);

    }

    public void revealSecret(View view) {


    }
}
