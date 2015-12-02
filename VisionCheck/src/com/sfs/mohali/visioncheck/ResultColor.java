package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultColor extends Activity {
	  public static TextView failedtest;
	  public static TextView text1;
	  public static TextView text2;
	  public static TextView text3;
	  public static TextView text4;
	  Button finish;
	  Button nexttest;
	  
	  public void onBackPressed() 
	  {
			// TODO Auto-generated method stub
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ResultColor.this);
		
			alertDialogBuilder.setTitle("Warning! All the saved data will be deleted.");

			alertDialogBuilder.setMessage("Do you want to continue ?").setCancelable(false).setPositiveButton("No",
							new DialogInterface.OnClickListener() 
					{
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
									//Intent intent = new Intent(ResultColor.this, VisionTests.class);
									//startActivity(intent);
									//finish();
								}
							})
					.setNegativeButton("Yes", new DialogInterface.OnClickListener() 
					{
						public void onClick(DialogInterface dialog, int id) {
							//dialog.cancel();
							Intent intent = new Intent(ResultColor.this, StartTest.class);
							startActivity(intent);
							finish();
						}
					});

			AlertDialog alertDialog = alertDialogBuilder.create();
			
			alertDialog.show();

		}

	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultcolor);
		
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		
		finish = (Button) findViewById(R.id.finishtest);
		nexttest = (Button) findViewById(R.id.nexttest);
		
		failedtest = (TextView) findViewById(R.id.failedtest);
		
		SelectButton1.sp = getSharedPreferences("saveyourdata", MODE_PRIVATE);
		
		text1.setText(SelectButton1.sp.getString("textvalue", " "));
		text2.setText(SelectButton1.sp.getString("textvalue1", " "));
		text3.setText(SelectButton1.sp.getString("textvalue2", " "));
		text4.setText(SelectButton1.sp.getString("textvalue3", " "));
		
		failedtest.setText("Your eyes have failed in some color tests.");

		if (text1.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
		}
		if (text2.getText().toString().equals("null")) 
		{
			text2.setVisibility(8);
		}

		if (text3.getText().toString().equals("null")) 
		{
			text3.setVisibility(8);
		}

		if (text4.getText().toString().equals("null")) 
		{
			text4.setVisibility(8);
		}
		if (text1.getText().toString().equals("null") && text2.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
			text2.setVisibility(8);
		}
		if (text1.getText().toString().equals("null") && text3.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
			text3.setVisibility(8);
		}
		if (text1.getText().toString().equals("null") && text4.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
			text4.setVisibility(8);
		}
		if (text2.getText().toString().equals("null") && text3.getText().toString().equals("null")) 
		{
			text2.setVisibility(8);
			text3.setVisibility(8);
		}
		if (text2.getText().toString().equals("null") && text4.getText().toString().equals("null")) 
		{
			text2.setVisibility(8);
			text4.setVisibility(8);
		}
		if (text3.getText().toString().equals("null") && text4.getText().toString().equals("null"))
		{
			text3.setVisibility(8);
			text4.setVisibility(8);
		}
		if (text1.getText().toString().equals("null") && text2.getText().toString().equals("null") 
				&& text3.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
			text2.setVisibility(8);
			text3.setVisibility(8);
		}

		if (text2.getText().toString().equals("null") && text3.getText().toString().equals("null")
				&& text4.getText().toString().equals("null"))
		{
			text2.setVisibility(8);
			text3.setVisibility(8);
			text4.setVisibility(8);
		}
		if (text4.getText().toString().equals("null") && text2.getText().toString().equals("null")
				&& text1.getText().toString().equals("null")) 
		{
			text4.setVisibility(8);
			text2.setVisibility(8);
			text1.setVisibility(8);
		}
		if (text4.getText().toString().equals("null") && text3.getText().toString().equals("null")
				&& text1.getText().toString().equals("null")) 
		{
			text4.setVisibility(8);
			text3.setVisibility(8);
			text1.setVisibility(8);
		}
		if (text1.getText().toString().equals("null")
				&& text2.getText().toString().equals("null")
				&& text3.getText().toString().equals("null")
				&& text4.getText().toString().equals("null")) 
		{
			text1.setVisibility(8);
			text2.setVisibility(8);
			text3.setVisibility(8);
			text4.setVisibility(8);
			
			failedtest.setVisibility(8);
		}
		
		this.finish.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				ResultColor.this.onBackPressed();
			}
		});
		
		this.nexttest.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ResultColor.this, Start_Ques1.class);
				startActivity(intent);
			}
		});
		
	}
	  
}
