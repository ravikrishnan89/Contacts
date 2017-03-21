package com.flipkart.contacts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flipkart.contacts.db.Contact;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ravi.krishnan on 07/03/17.
 */

public class ContactListAdapter extends Adapter<ContactListAdapter.ContactViewHolder> {


    private List<Contact> contactList;
    private Context context;

    public ContactListAdapter(List<Contact> contactList,Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName, lastName;
        public ImageView contactImageView;

        public ContactViewHolder(View view) {
            super(view);
            firstName = (TextView) view.findViewById(R.id.firstName);
            lastName = (TextView) view.findViewById(R.id.lastName);
            contactImageView = (ImageView) view.findViewById(R.id.contactImage);
        }
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item_layout, parent, false);
        return new ContactViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        Picasso.with(context).load(contact.getProfilePic()).
                into(holder.contactImageView);
        holder.firstName.setText(contact.getFirstName());
        holder.lastName.setText(contact.getLastName());
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
