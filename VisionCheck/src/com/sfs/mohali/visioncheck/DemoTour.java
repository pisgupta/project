package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DemoTour extends Activity {
	ImageView colortest, ques, acuity, motor, camera;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo);
		colortest = (ImageView)findViewById(R.id.colortests);
		ques = (ImageView)findViewById(R.id.questionstest);
		acuity = (ImageView)findViewById(R.id.visionacuitytest);
		motor = (ImageView)findViewById(R.id.motortest);
		camera = (ImageView)findViewById(R.id.cameracapturetest);

		colortest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog d = new Dialog(DemoTour.this);
				 d.requestWindowFeature(Window.FEATURE_NO_TITLE);
				d.setContentView(R.layout.dialog_color_test);
				Button btn = (Button) d.findViewById(R.id.colorgotit);
				btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						d.dismiss();
					}
				});
				d.show();
			}
		});
		ques.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog quesdialog = new Dialog(DemoTour.this);
				quesdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				quesdialog.setContentView(R.layout.dialog_ques);
				Button btn = (Button) quesdialog.findViewById(R.id.quesgotit);
				btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Toast.makeText(getApplicationContext(), "Test",
						// 1).show();
						quesdialog.dismiss();
					}
				});
				quesdialog.show();
			}
		});

		acuity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog acuitydialog = new Dialog(DemoTour.this);
				acuitydialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				acuitydialog.setContentView(R.layout.dialog_acuity);
				Button btn = (Button) acuitydialog
						.findViewById(R.id.acuitygotit);
				btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Toast.makeText(getApplicationContext(), "Test",
						// 1).show();
						acuitydialog.dismiss();
					}
				});
				acuitydialog.show();
			}
		});
		camera.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog cameradialog = new Dialog(DemoTour.this);
				cameradialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				cameradialog.setContentView(R.layout.dialog_camera);
				Button btn = (Button) cameradialog.findViewById(R.id.camgotit);
				btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Toast.makeText(getApplicationContext(), "Test",
						// 1).show();
						cameradialog.dismiss();
					}
				});
				Button btn1=(Button)cameradialog.findViewById(R.id.camtutorial);
				btn1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intcam=new Intent(DemoTour.this,DemoCameraTutorial.class);
						startActivity(intcam);
					}
				});
				cameradialog.show();
			}
		});
            motor.setOnClickListener(new View.OnClickListener() {
            @Override
			public void onClick(View arg0) {
                final Dialog motordialog = new Dialog(DemoTour.this);
				motordialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				motordialog.setContentView(R.layout.dialog_motor);
				Button btn = (Button) motordialog.findViewById(R.id.motorgotit);
				btn.setOnClickListener(new View.OnClickListener() 
				{
                    @Override
					public void onClick(View arg0) 
					{
						motordialog.dismiss();
					}
				});
				motordialog.show();
			}
		});
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
