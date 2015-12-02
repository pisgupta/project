package com.sfs.mohali.visioncheck;

import java.util.ArrayList;

import com.example.visioncheck.R;
import com.sfs.mohali.vision.constant.Mypreferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ques_Result extends Activity {
	int count = 0;
	TextView txtresult1, txtresult2, txtresult3;
 Button finish,next;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questiontestresult);

		txtresult1 = (TextView) findViewById(R.id.textView2);
		txtresult2 = (TextView) findViewById(R.id.textView3);
		txtresult3 = (TextView) findViewById(R.id.textView4);
		finish= (Button)findViewById(R.id.questiontestfinishButton);
		next=(Button)findViewById(R.id.questiontestnextButton);
finish.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	Intent intfinish=new Intent(Ques_Result.this,StartTest.class);
	startActivity(intfinish);
	}
});
next.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intnext=new Intent(Ques_Result.this,AcuityTest.class);
		startActivity(intnext);
	}
});
		Mypreferences mp = new Mypreferences(this);
		ArrayList<String> data = mp.getAll();

		for (int i = 0; i < data.size(); i++) {
			if (i == 0) {
				if (data.get(i).equalsIgnoreCase("Yes")) {
					txtresult1
							.append(" Failed Question 1:"
									+ "Ultravoilet light can damage your eyes.You should weat sunglasses with UVA protection."
									+ "\n");
				} else {

				}
			} else if (i == 1) {
				if (data.get(i).equalsIgnoreCase("Yes")) {
					txtresult2
							.append("Failed Question 2:"
									+ "It's quite possible your local registered optician may be able to help with this."
									+ "\n");
				} else {
				}
			} else if (i == 2) {
				if (data.get(i).equalsIgnoreCase("Yes")) {
					txtresult3
							.append("Failed Question 3:"
									+ "It's recommended you get an eye test atleast once a year"
									+ "\n");

				}
			}

		}

	}

}
