package com.ubicuaandroid.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.albertoguerrero.ubicuaandroid.app.R;


public class PhoneListAdapter extends ArrayAdapter<Contact>
{
    int layoutResourceId;

    public PhoneListAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId);
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {

            LayoutInflater vi = LayoutInflater.from(getContext());
            row = vi.inflate(R.layout.phone_cell, null);
        }

        Contact contact = getItem(position);

        if (contact != null) {
            TextView nameView = (TextView) row.findViewById(R.id.nameTextView);
            TextView phoneView = (TextView) row.findViewById(R.id.phoneNumberTextView);

            nameView.setText(contact.getName());
            phoneView.setText(contact.getPhoneNumber());
        }

        return row;
    }
}
