package com.sfs.mohali.visioncheck;
import android.R.string;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class MyDatabase extends SQLiteOpenHelper{

		public static final String DBPATIENTID= "patientid";
		public static final int VERSIONID = 1;
		public static final String TABLENAME = "idtable";
		public static String TCID = "cuid";
		public static String TCNAME = "name";
		public static String TCAGE = "age";
		public static String TCPHONE ="phn";
		public static String TCEMAIL="email";
		public String query = "create table " + TABLENAME + " ( " + TCID
				+ " INTEGER primary key, " + TCNAME + " TEXT, "
				+ TCAGE + " int, " + TCPHONE + " TEXT, " + TCEMAIL + " TEXT)";
		public MyDatabase(Context ct) {
			super(ct,DBPATIENTID , null, VERSIONID);
			Log.e("data baseeeeeee", "Db Createeeeeeeee");
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
				db.execSQL(query);
				Log.e("Table Createeeeeeeeeee", "Table Ceate");
			} catch (Exception e) {
				// TODO: handle exception
				Log.e("Table Createeeeeeeeeee", e.toString());
			}
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}
	}