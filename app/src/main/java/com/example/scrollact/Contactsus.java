package com.example.scrollact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Contactsus extends AppCompatActivity {

    Contactus_CustomAdapter contactus_customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactsus);

        contactus_customAdapter = new Contactus_CustomAdapter(this);
    }
}
