package com.albertoguerrero.ubicuaandroid.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.albertoguerrero.ubicuaandroid.app.Adapters.PhoneListAdapter;

public class MainActivity extends Activity {

    private EditText phoneText;
    private ListView phoneList;
    private Button addButton;

    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.phoneText = (EditText) findViewById(R.id.main_phoneText);

        //--- Set ListView ---
        this.phoneList = (ListView) findViewById(R.id.main_phoneList);
        this.phoneList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        this.phoneList.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.cabselection_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

        this.arrayAdapter = new ArrayAdapter<>(this, R.layout.phone_cell);
        this.phoneList.setAdapter(this.arrayAdapter);
        //--------------------

        //--- Set add button ---
        this.addButton = (Button) findViewById(R.id.main_addButton);
        this.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneText.getText().toString();
                arrayAdapter.add(phoneNumber);
                phoneText.setText("");
            }
        });
        //----------------------
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
