package com.seesaysaw.contractcountdown;

import com.seesaysaw.contractcountdown.Menu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
	
	
	///////////////////////////////////////////////////////////////////////////////////////

	
	String MenuItems[] = {"Contracts", "Expired Contacts"};

	
	///////////////////////////////////////////////////////////////////////////////////////

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, MenuItems));
		
	}

	
	///////////////////////////////////////////////////////////////////////////////////////


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese = MenuItems[position];
		
		Class ourClass;
		try {
			ourClass = Class.forName("com.seesaysaw.contractcountdown." + cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////

	
}
