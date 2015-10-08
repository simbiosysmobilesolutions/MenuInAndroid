package com.simbiosyscorp.tutorials.menuinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class StaticallyAddedOptionsMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statically_added_options_menu);
    }
public void next(View view){
    startActivity(new Intent(this,DynamicallyAddedOptionsMenu.class));
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_statically_added_optionsmenu, menu);


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
        }else if(id==R.id.file){
            Toast.makeText(StaticallyAddedOptionsMenu.this, "You clicked on File", Toast.LENGTH_SHORT).show();
        }else if (id==R.id.edit){
            Toast.makeText(StaticallyAddedOptionsMenu.this, "You clicked on Edit", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.view){
            Toast.makeText(StaticallyAddedOptionsMenu.this, "You clicked on View", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
