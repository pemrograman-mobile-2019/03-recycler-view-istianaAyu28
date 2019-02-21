package com.example.recyclerviewayu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerviewayu.R;
import com.example.recyclerviewayu.models.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>  {
    //atribut
    private final List<Contact> mContact;
    private List<Contact> Contact;

    //konstruktor
    public ContactsAdapter(List<Contact> mContact){
        this.mContact=mContact;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //menghubungkan item_contact.xml ke adapter
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, viewGroup, false);
        ViewHolder viewHolder= new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    //menghubungkan nilai masing" item
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    Contact contact = mContact.get(i);
    TextView textView = viewHolder.nameTextView;
    textView.setText(contact.getmName());
    Button button = viewHolder.messageButton;
    button.setText(contact.ismOnline()?"Message":"Offline");
    button.setEnabled(contact.ismOnline());

    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        private TextView nameTextView;
        private Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
