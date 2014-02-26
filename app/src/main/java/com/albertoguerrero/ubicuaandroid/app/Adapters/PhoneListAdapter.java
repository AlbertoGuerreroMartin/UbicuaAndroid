package com.albertoguerrero.ubicuaandroid.app.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.albertoguerrero.ubicuaandroid.app.Contact;

/**
 * Created by albertoguerreromartin on 26/02/14.
 */
public class PhoneListAdapter<Contact> extends ArrayAdapter<Contact>
{
    Context context;
    int layoutResourceId;
    Contact data[] = null;

    public PhoneListAdapter(Context context, int layoutResourceId, Contact[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;


        return row;
    }
}
