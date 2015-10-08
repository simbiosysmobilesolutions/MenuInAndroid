package com.simbiosyscorp.tutorials.menuinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StaticallyCreatedContextMenuOptions extends AppCompatActivity {
    TextView textViewForContextMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statically_created_context_menu_options);
        textViewForContextMenu = (TextView) findViewById(R.id.textView_for_static_contextmenu);
        registerForContextMenu(textViewForContextMenu);
    }
    public void next(View view) {

        startActivity(new Intent(getApplicationContext(), DynamicallyAddedContextMenu.class));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.statically_created_context_menu_options, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_copy) {
            Toast.makeText(getApplicationContext(), "You clicked on Copy", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_cut) {
            Toast.makeText(getApplicationContext(), "You clicked on Cut", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_select) {
            Toast.makeText(getApplicationContext(), "You clicked on Select", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }
}
