package com.sfs.mohali.visioncheck;

import java.io.File;
import java.util.Locale;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;

public class Start_Ques3 extends Activity {
	Mypreferences mypreferences;
TextToSpeech textspeech3;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_question3);
		mypreferences = new Mypreferences(this);
		textspeech3= new TextToSpeech(Start_Ques3.this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if (status != TextToSpeech.ERROR) {
					textspeech3.setLanguage(Locale.US);
					textspeech3.setSpeechRate(1.0f);
				}
				String speechques3 = "Has it been over two years since your last eyetest";
				textspeech3.speak(speechques3,TextToSpeech.QUEUE_FLUSH, null);
			}
		});	
		findViewById(R.id.quest3yes).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
					textspeech3.stop();
						textspeech3.shutdown();
						mypreferences.saveYesNo("Question3", "Yes");
						Intent intentques3 = new Intent(Start_Ques3.this,
								Ques_Result.class);
						startActivity(intentques3);
						
					}
				});
		findViewById(R.id.quest3no).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						textspeech3.stop();
						textspeech3.shutdown();
						mypreferences.saveYesNo("Question3", "No");
						Intent intentques3 = new Intent(Start_Ques3.this,
								Ques_Result.class);
						startActivity(intentques3);
					}
				});

	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		textspeech3.stop();
		textspeech3.shutdown();
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					Start_Ques3.this);
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
							Intent intent = new Intent(Start_Ques3.this,
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


