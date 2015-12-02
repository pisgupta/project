package com.sfs.mohali.visioncheck;

import java.util.Locale;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AcuityTest extends Activity {

	Button btnstop,btnnext;
	TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
	int count=0;
	TextToSpeech textToSpeech;
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.acuitytest);
				tv1=(TextView)findViewById(R.id.acuitytext1);
				tv2=(TextView)findViewById(R.id.acuitytext2);
				tv3=(TextView)findViewById(R.id.acuitytext3);
				tv4=(TextView)findViewById(R.id.acuitytext4);
				tv5=(TextView)findViewById(R.id.acuitytext5);
				tv6=(TextView)findViewById(R.id.acuitytext6);
				tv7=(TextView)findViewById(R.id.acuitytext7);
				tv8=(TextView)findViewById(R.id.acuitytext8);
				btnstop= (Button)findViewById(R.id.acuitystop);
				btnnext=(Button)findViewById(R.id.acuitynext);
				final String speech = "If you can read all letters click next if you cannot read all letters click stop";
				textToSpeech = new TextToSpeech(AcuityTest.this,

				new TextToSpeech.OnInitListener() {
					@Override
					public void onInit(int status) {
						if (status != TextToSpeech.ERROR) {
							textToSpeech.setLanguage(Locale.ENGLISH);
							textToSpeech.setSpeechRate(1f);
						}
						String random = speech;
						textToSpeech.speak(random, TextToSpeech.QUEUE_FLUSH, null);
					}
				});
				btnnext.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						textToSpeech.stop();
						textToSpeech.shutdown();
					count=count+1;
					if(count==1)
					{
					tv2.setVisibility(View.INVISIBLE);
				}
					if (count==2)
					{
						tv2.setVisibility(View.VISIBLE);
						tv1.setVisibility(View.INVISIBLE);
					}
					if (count==3)
					{
						tv3.setVisibility(View.VISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
						
					}
					if (count==4)
					{
						tv4.setVisibility(View.VISIBLE);
						tv3.setVisibility(View.INVISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
						
					}
					if (count==5)
					{
						tv5.setVisibility(View.VISIBLE);
						tv4.setVisibility(View.INVISIBLE);
						tv3.setVisibility(View.INVISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
						
					}
					if (count==6)
					{
						tv6.setVisibility(View.VISIBLE);
						tv5.setVisibility(View.INVISIBLE);
						tv4.setVisibility(View.INVISIBLE);
						tv3.setVisibility(View.INVISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
						
					}
					if (count==7)
					{
						tv7.setVisibility(View.VISIBLE);
						tv6.setVisibility(View.INVISIBLE);
						tv5.setVisibility(View.INVISIBLE);
						tv4.setVisibility(View.INVISIBLE);
						tv3.setVisibility(View.INVISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
						
					}if (count==8)
					{
						tv8.setVisibility(View.VISIBLE);
						tv7.setVisibility(View.INVISIBLE);
						tv6.setVisibility(View.INVISIBLE);
						tv5.setVisibility(View.INVISIBLE);
						tv4.setVisibility(View.INVISIBLE);
						tv3.setVisibility(View.INVISIBLE);
						tv1.setVisibility(View.INVISIBLE);
						tv2.setVisibility(View.INVISIBLE);
					}
					if(count==9)
					{
						AlertDialog.Builder ab = new AlertDialog.Builder(AcuityTest.this);
						ab.setTitle("Congrats! You have cleared this Test");
						ab.setMessage("Kindly proceed to next test.");
						ab.setNeutralButton("Next Test",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
									Intent camint= new Intent(AcuityTest.this, MotarTest.class);
									startActivity(camint);
									}
								});
						ab.show();
					}
					}
					});
				btnstop.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						textToSpeech.stop();
						textToSpeech.shutdown();
						AlertDialog.Builder ab1 = new AlertDialog.Builder(AcuityTest.this);
						ab1.setTitle("You are unable to clear this Test.");
						ab1.setMessage("You seem to have problems with seeing details at certain distances. You should visit an eye doctor to have an accurate test.");
						ab1.setPositiveButton("Go to Home",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
									Intent startint= new Intent(AcuityTest.this, StartTest.class);
									startActivity(startint);
									}
								});	
						ab1.setNegativeButton("Next Test",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								Intent camintent= new Intent(AcuityTest.this, CameraTest.class);
								startActivity(camintent);
								
							}
						});
						ab1.show();
					}
				});
				
}}		
	

