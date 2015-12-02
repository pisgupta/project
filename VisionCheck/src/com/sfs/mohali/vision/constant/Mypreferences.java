package com.sfs.mohali.vision.constant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

public class Mypreferences {

	SharedPreferences spPreferences;
	SharedPreferences.Editor editor;

	public Mypreferences(Context ct) {

		spPreferences = ct.getSharedPreferences("questiontest",
				Context.MODE_MULTI_PROCESS);

	}

	public void saveYesNo(String key, String value) {

		editor = spPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public ArrayList<String> getAll() {
		ArrayList<String> data = new ArrayList<String>();
		Map m = spPreferences.getAll();

		Set<String> se = m.keySet();
		Iterator<String> it = se.iterator();
		int count = 1;
		while (it.hasNext()) {
			String key = it.next().toString();
			data.add(spPreferences.getString("Question" + count, ""));
			count++;
		}
		return data;
	}
public void setflag(int flag) {
	editor=spPreferences.edit();
	editor.putInt("flag", flag);
	editor.commit();
	}
public int getflag() {
 return spPreferences.getInt("flag",0);
}
}
