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

public class Start_Ques2 extends Activity{
	Mypreferences preferences;
	TextToSpeech textSpeechques2;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.start_question2);
	textSpeechques2=new TextToSpeech(Start_Ques2.this, new TextToSpeech.OnInitListener() {
		
		@Override
		public void onInit(int status) {
			// TODO Auto-generated method stub
			if(status==TextToSpeech.SUCCESS)
			{
				textSpeechques2.setLanguage(Locale.ENGLISH);
				textSpeechques2.setSpeechRate(1.0f);
			}
			String ques2="Working on computer after a period of time,do you experience headaches or tired eyes";
			textSpeechques2.speak(ques2, TextToSpeech.QUEUE_FLUSH, null);
		}
	});
	preferences= new Mypreferences(this);
findViewById(R.id.quest2yes).setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		textSpeechques2.stop();
		textSpeechques2.shutdown();
		preferences.saveYesNo("Question2", "Yes");
		Intent intentques2=new Intent(Start_Ques2.this,Start_Ques3.class);
		startActivity(intentques2);
	}
});
findViewById(R.id.quest2no).setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		textSpeechques2.stop();
		textSpeechques2.shutdown();
		preferences.saveYesNo("Question2","No");
		Intent intentques2=new Intent(Start_Ques2.this,Start_Ques3.class);
		startActivity(intentques2);
	}
});

}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
textSpeechques2.stop();
textSpeechques2.shutdown();
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				Start_Ques2.this);
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
						
						Intent intent = new Intent(Start_Ques2.this,
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
