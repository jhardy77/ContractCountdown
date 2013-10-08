package com.seesaysaw.contractcountdown;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Contracts extends Activity implements OnClickListener {

	
	TextView c, cd, ct;
	Button update;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contractsview);
		initializeVariables();
		update.setOnClickListener(Contracts.this);
				
	}

	private void initializeVariables() {
		// TODO Auto-generated method stub
		c = (TextView) findViewById(R.id.c);
		ct = (TextView) findViewById(R.id.ct);
		cd = (TextView) findViewById(R.id.cd);
		update = (Button) findViewById(R.id.Update);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

				switch (arg0.getId()) {

				case R.id.Update:

					boolean didItWork = true;
					
					try {
						// Gets any data from the et_sqlName
						String getc1 = c.getText().toString();
						String getcd1 = cd.getText().toString();
						String getct1 = ct.getText().toString();

						DatabaseMethod entry = new DatabaseMethod(Contracts.this);
						entry.open();
						entry.createEntry(getc1, getcd1, getct1);
						entry.close();
					} catch (Exception e) {
						didItWork = false;
						String error = e.toString();
						Dialog d = new Dialog(Contracts.this);
						d.setTitle("Dang it");
						TextView tv = new TextView(Contracts.this);
						tv.setText(error);
						d.setContentView(tv);
						d.show();
						
						
					} finally {
						if (didItWork) {
							Dialog d = new Dialog(Contracts.this);
							d.setTitle("Heck Yea!");
							TextView tv = new TextView(Contracts.this);
							tv.setText("Success");
							d.setContentView(tv);
							d.show();
						}
					}

					break;

				case R.id.b_sqlView:
					Intent i = new Intent("com.thenewboston.travis.SQLVIEW");
					startActivity(i);
					break;

				}
		
	}
	
	
	

}
