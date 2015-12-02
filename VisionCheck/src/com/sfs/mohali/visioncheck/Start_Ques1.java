package com.sfs.mohali.visioncheck;

import java.util.Locale;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start_Ques1 extends Activity {
	Mypreferences mypreferences;
TextToSpeech texttospeech;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_question1);
		texttospeech=new TextToSpeech(Start_Ques1.this, new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
				// TODO Auto-generated method stub
				if(status==TextToSpeech.SUCCESS)
				{
					texttospeech.setLanguage(Locale.ENGLISH);
					texttospeech.setSpeechRate(1.0f);
				}
				String ques1="Do you smoke, or are you in regular close proximity of someone who does";
				texttospeech.speak(ques1, TextToSpeech.QUEUE_FLUSH, null);
			}
		});

		mypreferences = new Mypreferences(this);
		findViewById(R.id.quest1yes).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						texttospeech.stop();
						texttospeech.shutdown();
						mypreferences.saveYesNo("Question1", "Yes");
						Intent ques1 = new Intent(Start_Ques1.this,
								Start_Ques2.class);
						startActivity(ques1);
					}
				});
		findViewById(R.id.quest1no).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						texttospeech.stop();
						texttospeech.shutdown();
						mypreferences.saveYesNo("Question1", "No");
						Intent ques1 = new Intent(Start_Ques1.this,
								Start_Ques2.class);
						startActivity(ques1);
					}
				});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	texttospeech.stop();
	texttospeech.shutdown();
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					Start_Ques1.this);
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
							
							Intent intent = new Intent(Start_Ques1.this,
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
