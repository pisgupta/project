package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DemoRightEye extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.demorighteye);
	findViewById(R.id.demorighteyepre).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent pevintent=new Intent(DemoRightEye.this,DemoCameraTutorial.class);
		startActivity(pevintent);
		}
	});
	findViewById(R.id.demorighteyenext).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent nextintent=new Intent(DemoRightEye.this,DemoLeftEye.class);
			startActivity(nextintent);
		}
	});
}
@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	finish();
}
@Override
public void onBackPressed() {
// TODO Auto-generated method stub
super.onBackPressed();
Intent intback= new Intent(DemoRightEye.this,DemoTour.class);
startActivity(intback);
}
}
