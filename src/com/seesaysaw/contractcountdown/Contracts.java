package com.seesaysaw.contractcountdown;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Contracts extends Activity implements OnClickListener {

	
	TextView c1, ct1, c2, ct2, c3, ct3;
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
		c1 = (TextView) findViewById(R.id.c1);
		ct1 = (TextView) findViewById(R.id.ct1);
		c2 = (TextView) findViewById(R.id.c2);
		ct2 = (TextView) findViewById(R.id.ct2);
		c3 = (TextView) findViewById(R.id.c3);
		ct3 = (TextView) findViewById(R.id.ct3);
		update = (Button) findViewById(R.id.Update);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
