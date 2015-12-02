package com.sfs.mohali.visioncheck;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ColorTest4 extends Activity {
	public static ImageView image4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.colortest4);
			
			image4 = (ImageView)findViewById(R.id.image4);
			image4.setOnClickListener(new View.OnClickListener() 
			{
				
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
				Intent localIntent = new Intent(ColorTest4.this, SelectButton4.class);
			    ColorTest4.this.startActivity(localIntent);
				}
			});
	  }
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
	ColorTest4.this);
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
							
							Intent intent = new Intent(ColorTest4.this,
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
