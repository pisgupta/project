package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DemoFinger extends Activity {
ImageView next,prev;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demofinger);
		next=(ImageView)findViewById(R.id.demofingernext);
		prev=(ImageView)findViewById(R.id.demofingerprevious);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent next= new Intent(DemoFinger.this,DemoPill.class);
			startActivity(next);
			}
		});
		prev.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent previous= new Intent(DemoFinger.this,DemoLeftEye.class);
				startActivity(previous);
				
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
Intent intback= new Intent(DemoFinger.this,DemoTour.class);
startActivity(intback);
}
}
