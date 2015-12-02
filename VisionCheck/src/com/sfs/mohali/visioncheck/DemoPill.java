package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DemoPill extends Activity {
	TextView back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
setContentView(R.layout.demopill);
back=(TextView)findViewById(R.id.demoback);
back.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intpill= new Intent(DemoPill.this,DemoTour.class);
		startActivity(intpill);
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
	Intent intback= new Intent(DemoPill.this,DemoTour.class);
	startActivity(intback);
}
}
