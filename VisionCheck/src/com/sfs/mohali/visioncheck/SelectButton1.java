package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectButton1 extends Activity {
	public static SharedPreferences sp;
	public static SharedPreferences.Editor spedit;

	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button notsure;

	@Override
		protected void onCreate(Bundle savedInstanceState) 
	{
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.selectbutton1);
			
			this.button1 = ((Button)findViewById(R.id.button1));
			this.button2 = ((Button)findViewById(R.id.button2));
			this.button3 = ((Button)findViewById(R.id.button3));
			this.button4 = ((Button)findViewById(R.id.button4));
			this.notsure = ((Button)findViewById(R.id.unsure));
			
			sp = getSharedPreferences("saveyourdata", MODE_MULTI_PROCESS);
		    spedit = sp.edit();
		    
		    if(R.id.image1 == ColorTest1.image1.getId())
		    {
		    	this.button1.setText("15");
		        this.button1.setTextSize(70.0F);
		        this.button2.setText("56");
		        this.button2.setTextSize(70.0F);
		        this.button3.setText("82");
		        this.button3.setTextSize(70.0F);
		        this.button4.setText("90");
		        this.button4.setTextSize(70.0F);
		       
		        button1.setOnClickListener(new View.OnClickListener() 
		        {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (button1.getText().equals("56")) 
						{
							spedit.putString("textvalue", "null");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are correct", 0).show();
						}
						else 
						{
							spedit.putString(
									"textvalue",
									"Failed in Question 1- Normal and those with colour deficients should see the number 56.");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are incorrect", 0).show();

						}

					}
				});
		        
				button2.setOnClickListener(new View.OnClickListener() 
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (button2.getText().equals("56")) 
						{

							spedit.putString("textvalue", "null");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are correct", 0).show();
						}
						else 
						{

							spedit.putString(
									"textvalue",
									"Failed in Question 1- Normal and those with colour deficients should see the number 56.");

							Intent mIntent = new Intent(SelectButton1.this,
									ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are incorrect", 0).show();

						}

					}
				});

				button3.setOnClickListener(new View.OnClickListener() 
				{

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (button3.getText().equals("56")) 
						{
							spedit.putString("textvalue", "null");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are correct", 0).show();
						}
						else 
						{

							spedit.putString(
									"textvalue",
									"Failed in Question 1- Normal and those with colour deficients should see the number 56.");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are incorrect", 0).show();

						}

					}
				});
				
				button4.setOnClickListener(new View.OnClickListener() 
				{

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (button4.getText().equals("56"))
						{
							spedit.putString("textvalue", "null");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);

							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are correct", 0).show();
						}
						else 
						{

							spedit.putString(
									"textvalue",
									"Failed in Question 1- Normal and those with colour deficients should see the number 56.");

							Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
							startActivity(mIntent);
							spedit.commit();
							Toast.makeText(getApplicationContext(), "you are incorrect", 0).show();

						}

					}
				});
				
				notsure.setOnClickListener(new View.OnClickListener() 
				{

					@Override
					public void onClick(View arg0) 
					{
						// TODO Auto-generated method stub

						spedit.putString(
								"textvalue",
								"Failed in Question 1- Normal and those with colour deficients should see the number 56.");

						Intent mIntent = new Intent(SelectButton1.this, ColorTest2.class);
						startActivity(mIntent);
						spedit.commit();
						Toast.makeText(getApplicationContext(), "you are incorrect", 0).show();
					}
				});
		    }
		}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
SelectButton1.this);
			// set dialog message
			alertDialogBuilder
					.setMessage("Do you want to continue ?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();

								}
							})
					.setNegativeButton("No", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {

							// if this button is clicked, close
							// current activity
							
							Intent intent = new Intent(SelectButton1.this,
								StartTest.class);
							startActivity(intent);
													}
					});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();

		}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
