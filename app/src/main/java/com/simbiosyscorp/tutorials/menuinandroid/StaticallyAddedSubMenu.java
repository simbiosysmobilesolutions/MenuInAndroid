package com.simbiosyscorp.tutorials.menuinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class StaticallyAddedSubMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statically_added_sub_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //Sub Menu can also be added to Context menus
        getMenuInflater().inflate(R.menu.menu_statically_added_sub_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.file) {
            Toast.makeText(getApplicationContext(), "You clicked on File", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.edit) {
            Toast.makeText(getApplicationContext(), "You clicked on Edit", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    public void next(View view) {

        startActivity(new Intent(getApplicationContext(),DynamicallyAddedSubMenu.class));
    }
}
