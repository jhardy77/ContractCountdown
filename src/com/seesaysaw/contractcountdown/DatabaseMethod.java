package com.seesaysaw.contractcountdown;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseMethod {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "contract_name";
	public static final String KEY_CONTRACTDATE = "contract_date_expire";
	public static final String KEY_CONTRACTTIME = "contract_time_expire";

	// Setup of database details
	private static final String DATABASE_NAME = "contractcountdowndb";
	private static final String DATABASE_TABLE = "contracttable";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + 
						KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
						KEY_NAME + " TEXT NOT NULL, " + 
						KEY_CONTRACTDATE + " TEXT NOT NULL, " +
						KEY_CONTRACTTIME + " TEXT NOT NULL);");

			// CREATE TABLE HotOrNotdb (
			// _id INTEGER PRIMARY KEY AUTOINCREMENT,
			// persons_name TEXT NOT NULL,
			// persons_hotness TEXT NOT NULL
			// );
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
	}

	public DatabaseMethod(Context c) {
		ourContext = c;
	}

	public DatabaseMethod open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	// Closes this class
	public void close() {
		ourHelper.close();
	}

	public long createEntry(String getc, String getcd, String getct) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, getc);
		cv.put(KEY_CONTRACTDATE, getcd);
		cv.put(KEY_CONTRACTTIME, getct);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { KEY_ROWID, KEY_NAME, KEY_CONTRACTDATE, KEY_CONTRACTTIME };
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int icd = c.getColumnIndex(KEY_CONTRACTDATE);
		int ict = c.getColumnIndex(KEY_CONTRACTTIME);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHotness) + "\n";
			
			
		}
		
		
		return result;
	}

}
