package com.simbiosyscorp.tutorials.menuinandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class DynamicallyAddedSubMenu extends AppCompatActivity {
    int groupId = 1;
    SubMenu subMenu;
    int menuITemFileID = 20, menuItemEditId = 30;
    int fileOrder = 200, editOrder = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamically_added_sub_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int subMenuGroupId = 2;
        getMenuInflater().inflate(R.menu.menu_dynamically_added_sub_menu, menu);
        //Adding SubMenu to Options Menu
        //Sub Menu can also be added to Context menus

        subMenu = menu.addSubMenu(groupId, menuITemFileID, fileOrder, "Sub Menu");
        //Adding items to the Sub Menu using the add function
        //add function takes groupid,itemid,order and text as parameters
        //Adding 2 items: File, Edit.
        subMenu.add(subMenuGroupId, menuITemFileID, fileOrder, "File");
        subMenu.add(subMenuGroupId, menuItemEditId, editOrder, "Edit");
        subMenu.setGroupCheckable(subMenuGroupId,true,true);

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
        } else if (id == menuITemFileID) {
            Toast.makeText(getApplicationContext(), "You clicked on File", Toast.LENGTH_SHORT).show();
        } else if (id == menuItemEditId) {
            Toast.makeText(getApplicationContext(), "You clicked on Edit", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
