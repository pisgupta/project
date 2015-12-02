package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	Mypreferences mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mp= new Mypreferences(getApplicationContext());
		new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					Thread.sleep(5000);
				}
				catch(Exception e)
				{
					
				}
				mp.setflag(1);
				Intent it=new Intent(MainActivity.this,Home.class);
				it.putExtra("count", 1);
				startActivity(it);
				MainActivity.this.finish();				
			}
		}).start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}