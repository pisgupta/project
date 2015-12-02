package com.sfs.mohali.visioncheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartPage extends Activity {
	Button start,demo,id;
	TextToSpeech Texttospeech;
	String zipFile;
	String zipfilename = "ClickedPictures.zip";

	File f;
	String email = Home.EMAIL;
	Paint paint;
	int count;
	Mypreferences mp;
	public static final int REQUESTCODE = 100;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.startpage);
	id = (Button) findViewById(R.id.send);
	mp= new Mypreferences(getApplicationContext());
	
	count=mp.getflag();

	id.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Log.e("eeeeeeeeeee", "Onclickeeeeeeeeee");

			zipFile = Environment.getExternalStorageDirectory().getPath()
					+ "/Pictures/CameraAPIDemo/" + zipfilename;

			File f = new File(Environment.getExternalStorageDirectory()
					.getPath() + "/Pictures/CameraAPIDemo/");

			final File allfile[] = f.listFiles();

			if (allfile.length < 5) {
				Toast.makeText(getApplicationContext(),
						"Kindly Please take the pictures of your eyes.", 0)
						.show();
			}

			else {
				try {
					// create byte buffer
					byte[] buffer = new byte[1024];

					FileOutputStream fos = new FileOutputStream(zipFile);

					ZipOutputStream zos = new ZipOutputStream(fos);

					for (int i = 0; i < allfile.length; i++) {
						File srcFile = new File(allfile[i].toString());
						FileInputStream fis = new FileInputStream(srcFile);
						zos.putNextEntry(new ZipEntry(srcFile.getName()));

						int length = 0;

						while ((length = fis.read(buffer)) > 0) {
							zos.write(buffer, 0, length);

						}

						length = 0;
						zos.closeEntry();
						// zos.flush();
						// close the InputStream
						fis.close();

					}

					// close the ZipOutputStream
					zos.close();
					// zos.flush();
				}

				catch (IOException ioe) {
					Log.e("rrrrrr", "pppppp");
				}
				Log.e("Sending mail",
						"Mail Successful");

				try {
					File filezip = new File(Environment
							.getExternalStorageDirectory().getPath()
							+ "/Pictures/CameraAPIDemo/" + zipfilename);
					String emailaddress[] = { email };
					// send picture through mail

					Intent emailIntent = new Intent(Intent.ACTION_SEND);
					emailIntent.setType("text/html");
					emailIntent.putExtra(Intent.EXTRA_SUBJECT,
							"File attached");
					emailIntent.putExtra(Intent.EXTRA_EMAIL, emailaddress);
					Uri uri = Uri.fromFile(filezip); // zipped file is
														// attached
														// to
														// the email
					emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
					startActivity(Intent.createChooser(emailIntent,
							"Send mail..."));
					try {
						startActivityForResult(Intent.createChooser(
								emailIntent, "Send mail..."), REQUESTCODE);
						//finish();
					} catch (Exception e) {
						// TODO: handle exception
					}

				} catch (Exception e) {
					Log.e("ssssssssssssssssssss", e.toString());

				} finally {

				}

			}
		}
	});

	start = (Button) findViewById(R.id.start);

	demo = (Button) findViewById(R.id.demo);

	final String speech = "Welcome..Please start your scheduled eye test or take a demo to get familiar with the test and its instructions";

	Texttospeech = new TextToSpeech(StartPage.this,

	new TextToSpeech.OnInitListener() {
		@Override
		public void onInit(int status) {
			if (status != TextToSpeech.ERROR) {
				Texttospeech.setLanguage(Locale.ENGLISH);
				Texttospeech.setSpeechRate(1f);
			}
			String random = speech;
			if(count==1){
				count=0;
			Texttospeech.speak(random, TextToSpeech.QUEUE_FLUSH, null);
		}
			else
			{} }
	});

	start.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stubt
			Texttospeech.stop();
			Texttospeech.shutdown();
			Intent intentstart = new Intent(StartPage.this,StartTest.class);
			startActivity(intentstart);
			Toast.makeText(getApplicationContext(), "Starting", 0).show();
		}
	});

	demo.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Texttospeech.stop();
			Texttospeech.shutdown();
			Intent ab = new Intent(StartPage.this, DemoTour.class);
			startActivity(ab);
			Toast.makeText(getApplicationContext(), "Launching Demo", 0).show();
		}
	});
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	Log.e("result", "trersukttttttttttttttttttttt");

	Log.e("requestCode", requestCode+"");
	Log.e("resultCode", resultCode+"");

	try {
		File zip = new File(zipFile);
		if (zip.delete()) {
			Toast.makeText(getApplicationContext(), "Zip delete", 1).show();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}

}
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	finish();
}
}
