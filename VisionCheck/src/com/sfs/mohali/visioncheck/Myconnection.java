package com.sfs.mohali.visioncheck;

import com.sfs.mohali.vision.constant.Bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Myconnection {
	SQLiteDatabase sqdb;
	MyDatabase mdb;

	public Myconnection(Context ct) {
		try {
			mdb = new MyDatabase(ct);
			sqdb = mdb.getWritableDatabase();
			Log.e("Both Db and table created", "Both Db and table created");
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("Both Db and table created", e.toString());
		}
	}

	String colname[] = { MyDatabase.TCID, MyDatabase.TCNAME, MyDatabase.TCAGE,
			MyDatabase.TCPHONE, MyDatabase.TCEMAIL };

	public long insertData(Bean bean) {
		long row = 0;
		ContentValues cv = new ContentValues();
		cv.put(MyDatabase.TCID, bean.getPersonId());
		cv.put(MyDatabase.TCNAME, bean.getPersonName());
		cv.put(MyDatabase.TCAGE, bean.getPersonAge());
		cv.put(MyDatabase.TCPHONE, bean.getPersonphn());
		cv.put(MyDatabase.TCEMAIL, bean.getPersonEmail());
		row = sqdb.insert(MyDatabase.TABLENAME, null, cv);
		return row;
	}

	String colname1[] = { MyDatabase.TCNAME, MyDatabase.TCEMAIL };

	public String selectDataWhere(String id) {
		StringBuilder sb = new StringBuilder();
		Cursor c = sqdb.query(MyDatabase.TABLENAME, colname1, "cuid = ? ",
				new String[] { id }, null, null, null);
//		Cursor c=null;
		if (c.getCount()==0) {
			return null;
		}
		
		c.moveToFirst();
		String Id = c.getString(0);
		String email = c.getString(1);
		sb.append(Id + "," + email);
		return sb.toString();
	}

}
