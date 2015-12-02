package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DemoLeftEye extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.demolefteye);
	findViewById(R.id.demolefteyenext).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent leftintent=new Intent(DemoLeftEye.this,DemoFinger.class);
			startActivity(leftintent);
		}
	});
findViewById(R.id.demolefteyeprev).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent leftintent=new Intent(DemoLeftEye.this,DemoRightEye.class);
			startActivity(leftintent);
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
Intent intback= new Intent(DemoLeftEye.this,DemoTour.class);
startActivity(intback);
}
}
