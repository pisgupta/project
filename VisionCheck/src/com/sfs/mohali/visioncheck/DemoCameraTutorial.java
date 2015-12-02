package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;

public class DemoCameraTutorial extends Activity{
	ImageView next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cameratutorial);
		next=(ImageView)findViewById(R.id.cameratutorialnext1);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent nextint= new Intent(DemoCameraTutorial.this,DemoRightEye.class);
				startActivity(nextint);
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
	Intent intback= new Intent(DemoCameraTutorial.this,DemoTour.class);
	startActivity(intback);
}
}
