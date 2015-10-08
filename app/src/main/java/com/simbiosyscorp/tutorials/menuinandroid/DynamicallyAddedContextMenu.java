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

public class DynamicallyAddedContextMenu extends AppCompatActivity {
TextView textViewForContextMenu;
    int groupId=1;
    MenuItem menuITemFile,menuItemEdit,menuItemView;
    int contextMenuItemCutID =20, contextMenuItemCopyID =30, contextMenuItemSelectID =40;
    int cutOrder =200, copyOrder =300, selectOrder =400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamically_added_context_menu);

        //Registering the View for a context Menu.
        //Context Menu is activated when you long-press the view
        textViewForContextMenu= (TextView) findViewById(R.id.textView_for_contextmenu);
        registerForContextMenu(textViewForContextMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.dynamically_added_context_menu, menu);
        //Adding items to the Context Menu using the add function
        //add function takes groupid,itemid,order and text as parameters
        //Adding 3 items: Cut, Copy, Select.
        menuITemFile=menu.add(groupId, contextMenuItemCutID, cutOrder,R.string.action_cut);
        menuItemEdit=menu.add(groupId, contextMenuItemCopyID, copyOrder,R.string.action_copy);
        menuItemView=menu.add(groupId, contextMenuItemSelectID, selectOrder,R.string.action_select);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id==contextMenuItemCopyID){
            Toast.makeText(getApplicationContext(), "You clicked on Copy", Toast.LENGTH_SHORT).show();
        }else if (id==contextMenuItemCutID){
            Toast.makeText(getApplicationContext(), "You clicked on Cut", Toast.LENGTH_SHORT).show();
        }else if(id==contextMenuItemSelectID){
            Toast.makeText(getApplicationContext(), "You clicked on Select", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);

    }
    public void next(View view) {

        startActivity(new Intent(getApplicationContext(),StaticallyAddedSubMenu.class));
    }
}
