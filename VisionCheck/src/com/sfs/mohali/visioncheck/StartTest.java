package com.sfs.mohali.visioncheck;

import java.util.Locale;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiConfiguration.Status;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StartTest extends Activity {
	ImageView colortest, ques, acuity, motor, camera;
	Mypreferences mp;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starttestpage);
		colortest = (ImageView) findViewById(R.id.colortests);
		ques = (ImageView) findViewById(R.id.questionstest);
		acuity = (ImageView) findViewById(R.id.visionacuitytest);
		motor = (ImageView) findViewById(R.id.motortest);
		camera = (ImageView) findViewById(R.id.cameracapturetest);
		mp= new Mypreferences(getApplicationContext());

		
		colortest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intentcolor = new Intent(StartTest.this,ColorTest1.class);
				startActivity(intentcolor);
			}
		});
		acuity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentacuity = new Intent(StartTest.this,
						AcuityTest.class);
				startActivity(intentacuity);
			}
		});
		ques.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentques = new Intent(StartTest.this,
						Start_Ques1.class);
				startActivity(intentques);
			}
		});
		motor.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentmotor = new Intent(StartTest.this, MotarTest.class);
				startActivity(intentmotor);
			}
		});
		camera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentcamera = new Intent(StartTest.this, CameraTest.class);
				startActivity(intentcamera);
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		mp.setflag(0);
	Intent intstart=new Intent(StartTest.this,StartPage.class);
	startActivity(intstart);
	}
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	ImageCaptureCallback.counter=1;
}	
@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	finish();
}

	public static void main(String[] args) {

	}

}
