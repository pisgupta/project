package com.sfs.mohali.visioncheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Bean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity {
	Myconnection con;
	EditText edtname, edtid, edtphn, edtage, edtemail;
	Button btnsave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		con = new Myconnection(this);
		edtname = (EditText) findViewById(R.id.nameEditText);
		edtage = (EditText) findViewById(R.id.ageEditText);
		edtid = (EditText) findViewById(R.id.p_idEditText);
		edtphn = (EditText) findViewById(R.id.phoneEditText);
		edtemail = (EditText) findViewById(R.id.emailEditText);
		findViewById(R.id.SaveRecordButton).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if (TextUtils.isEmpty(edtname.getText().toString().trim())) {
							edtname.setError("Please Enter Your First Name");
							edtname.requestFocus();
							return;
						}

						if (TextUtils.isEmpty(edtage.getText().toString().trim())) {
							edtage.setError("Please Enter Your Last Name");
							edtage.requestFocus();
							return;
						}
						
						if (TextUtils.isEmpty(edtemail.getText().toString().trim())) {
							edtemail.setError("Please Enter Email Address");
							edtemail.requestFocus();
							return;
						}
						
						if(!isValidEmail(edtemail.getText().toString().trim()))
						{
							edtemail.setError("Invalid Email Address");
							edtemail.requestFocus();
							return;
							
						}
						
						if (TextUtils.isEmpty(edtphn.getText().toString().trim())) {
							edtphn.setError("Please Enter Mobile Number");
							edtphn.requestFocus();
							return;
						}
						if(edtphn.getText().toString().trim().length()!=10)
						{
							edtphn.setError("Please Enter Mobile Number of 10 digits");
							edtphn.requestFocus();
							return;
						}

						if (TextUtils.isEmpty(edtid.getText().toString().trim())) {
							edtid.setError("Please Enter User ID");
							edtid.requestFocus();
							return;
						}
					
						Bean bean = new Bean();
						bean.setPersonId(edtid.getText().toString());
						bean.setPersonName(edtname.getText().toString());
						bean.setPersonAge(Integer.parseInt(edtage.getText()
								.toString()));
						bean.setPersonphn(edtphn.getText().toString());
						bean.setPersonEmail(edtemail.getText().toString());
						long row = con.insertData(bean);
						if (row > 0) {
							Toast.makeText(getApplicationContext(), "Data Inserted", 0).show();
							Intent inthome= new Intent(Registration.this,StartPage.class);
							startActivity(inthome);
						} else {
							Toast.makeText(getApplicationContext(),
									"Data Not Inserted", 0).show();
						}
						
					}
				});
	}
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
		}
}
