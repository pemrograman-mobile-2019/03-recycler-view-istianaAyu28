package com.example.recyclerviewayu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewayu.adapter.ContactsAdapter;
import com.example.recyclerviewayu.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<Contact> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContact = (RecyclerView) findViewById(R.id.rvContacts);

        contacts = Contact.createContactsList(20);
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        rvContact.setAdapter(adapter);
        rvContact.setLayoutManager(new LinearLayoutManager(this));
    }
}
