package com.seesaysaw.contractcountdown;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class CCSplash extends Activity {

	MediaPlayer ourSplashSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ccsplash);
		
		ourSplashSong = MediaPlayer.create(CCSplash.this, R.raw.splash_sound);
		ourSplashSong.start();
		
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent("com.seesaysaw.contractcountdown.MENU");
					startActivity(openStartingPoint);
				}	
			}
		};
		timer.start();
		
		
	}
	
	//This will scrap the splash screen and song part so the back button doesn't go back to splash event
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSplashSong.release();
		finish();
	}
	
	

}
