package com.ubicuaandroid.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.albertoguerrero.ubicuaandroid.app.R;

public class MainActivity extends Activity {

    public static final int MAX_CONTACTS = 20;

    private EditText nameText;
    private EditText phoneText;
    private ListView phoneList;
    private Button addButton;

    private PhoneListAdapter phoneListAdapter;

    private int numContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numContacts=0;

        this.phoneText = (EditText) findViewById(R.id.main_phoneText);
        this.nameText = (EditText) findViewById(R.id.main_nameText);

        //--- Set ListView ---
        this.phoneList = (ListView) findViewById(R.id.main_phoneList);

        this.phoneListAdapter = new PhoneListAdapter(this, R.layout.phone_cell);
        this.phoneList.setAdapter(this.phoneListAdapter);
        this.phoneList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String uri = "tel:" + phoneListAdapter.getItem(position).getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
        //--------------------

        //--- Set add button ---
        this.addButton = (Button) findViewById(R.id.main_addButton);
        this.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString(), phone = phoneText.getText().toString();
                if(numContacts<MAX_CONTACTS)
                {
                    Contact newContact = new Contact(name, phone);
                    phoneListAdapter.add(newContact);
                    nameText.setText("");
                    phoneText.setText("");
                }
            }
        });
        //----------------------
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.delete_entry) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
