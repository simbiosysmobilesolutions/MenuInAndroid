package com.simbiosyscorp.tutorials.menuinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DynamicallyAddedOptionsMenu extends AppCompatActivity {
    MenuItem menuITemFile,menuItemEdit,menuItemView;
    int menuITemFileID=20,menuItemEditId=30,menuItemViewId=40;
    int fileOrder=200,editOrder=300,viewOrder=400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamically_added_options_menu);
    }


    public void next(View view) {

        startActivity(new Intent(getApplicationContext(),StaticallyCreatedContextMenuOptions.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int groupId=1;

        getMenuInflater().inflate(R.menu.menu_dynamically_added_optionsmenu, menu);

            //Adding items to the options menu using the add function
            //add function takes groupid,itemid,order and text as parameters
            //Adding 3 items to options menu: File, Edit and View.
        menuITemFile=menu.add(groupId,menuITemFileID,fileOrder,R.string.file);
        menuItemEdit=menu.add(groupId,menuItemEditId,editOrder,R.string.edit);
        menuItemView=menu.add(groupId,menuItemViewId,viewOrder,R.string.view);

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
        }else if(id==menuITemFileID){
            Toast.makeText(DynamicallyAddedOptionsMenu.this, "You clicked on File", Toast.LENGTH_SHORT).show();
        }else if (id==menuItemEditId){
            Toast.makeText(DynamicallyAddedOptionsMenu.this, "You clicked on Edit", Toast.LENGTH_SHORT).show();
        }else if(id==menuItemViewId){
            Toast.makeText(DynamicallyAddedOptionsMenu.this, "You clicked on View", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
