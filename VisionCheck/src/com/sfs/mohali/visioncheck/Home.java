package com.sfs.mohali.visioncheck;

import java.io.File;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.visioncheck.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity
{
 EditText edtpatientid, edtdocid;
 String zipFile;
	String zipfilename = "ClickedPictures.zip";

 TextView msg;
 Button btnlogin,createnew;
 int count=0;
 Myconnection con;
 LayoutInflater inflater;
	static String EMAIL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
			con= new Myconnection(this);
		edtpatientid=(EditText)findViewById(R.id.editText1);
		edtdocid=(EditText)findViewById(R.id.editText2);
		msg=(TextView)findViewById(R.id.textView3);
		btnlogin=(Button)findViewById(R.id.button1);
		btnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			btnlogin.setSoundEffectsEnabled(true);	
			count=count++;
				String s=con.selectDataWhere(edtpatientid.getText()
						.toString().trim());
				if(s==null||count==1){
			
						edtpatientid.setError("Please Valid Enter login id");
						edtpatientid.requestFocus();
						return;
					}
				
				if (TextUtils.isEmpty(edtdocid.getText().toString().trim())) {
					edtdocid.setError("Please Enter Email Address");
					edtdocid.requestFocus();
					return;
				}
				
				if(!isValidEmail(edtdocid.getText().toString().trim()))
				{
					edtdocid.setError("Invalid Email Address");
				edtdocid.requestFocus();
					return;
					
				}
				else
				{
				Toast.makeText(getApplicationContext(),"WELCOME",0).show();
				Intent in= new Intent(Home.this,StartPage.class);
                startActivity(in);
				}
			}
		});
		
		findViewById(R.id.create_new).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentreg= new Intent(Home.this,Registration.class);
				startActivity(intentreg);
			}
		});
		EMAIL=edtdocid.getText().toString();

	}
	private boolean isValidEmail(String email) {
	String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	 
	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	Matcher matcher = pattern.matcher(email);
	return matcher.matches();
	}
	public void refresh()
	{
		edtpatientid.setText(" ");
		edtdocid.setText(" ");
		msg.setVisibility(View.GONE);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
//@Override
//	protected void onRestart() {
//		// TODO Auto-generated method stub
//	zipFile = Environment.getExternalStorageDirectory().getPath() 
//			+ "/Pictures/CameraAPIDemo/" + zipfilename; // setting the path
//														// of the zipfile
//														// that is to be
//														// created
//	File f = new File(Environment.getExternalStorageDirectory().getPath() + "/Pictures/CameraAPIDemo/");
//	
//	final File allfile[] = f.listFiles();
//    boolean deleted= f.delete();
//    Log.e("delete file","file deleted:"+ deleted);
//
//
//		super.onRestart();
//	}
}
		


	
	