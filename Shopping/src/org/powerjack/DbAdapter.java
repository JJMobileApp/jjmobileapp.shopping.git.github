package org.powerjack;

import android.util.Log;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;

public class DbAdapter {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PRICE = "price";
	private static final String TAG = "DbAdapter";
	private DatabaseHelper dbHelper;
	private SQLiteDatabase SQLDb;
	private static final String DATABASE_CREATE = "CREATE TABLE shopping_list (_id integer primary key autoincrement, name text not null, price text not null)";
	private static final String DATABASE_DROP_TABLE = "DROP TABLE IF EXISTS shopping_list";
	private static final String DATABASE_NAME = "data";
	private static final String DATABASE_TABLE = "shopping_list";
	private static final int DATABASE_VERSION = 2;
	private final Context ctx = null;

	// klasa pomocna w operacjach na bazie
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper (Context context)	
		{
    	super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate (SQLiteDatabase db)
		{
    	db.execSQL(DATABASE_CREATE); 
    	}
		
		@Override
		public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)
		{
			Log.w(TAG, "Upgrading database");
			db.execSQL(DATABASE_DROP_TABLE);
			onCreate(db);
		}
    }

	// otwarcie polaczenia z baza
	DbAdapter open() throws SQLException
	{
		dbHelper = new DatabaseHelper(ctx);
		SQLDb = dbHelper.getWritableDatabase();
		return this;
	}
	
	// zamkniecie polaczenia z baza
	public void close()
	{
		dbHelper.close();
	}
		
	// dodanie wiersza do bazy
	public long createItem(String name, String price)
	{
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, name);
		initialValues.put(KEY_PRICE, price);
		return SQLDb.insert(DATABASE_TABLE, null, initialValues);
	}

	// usuniecie wiersza z bazy
	public boolean deleteItem(long rowId)
	{
		return SQLDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}
	
	public Cursor fetchAllItem()
	{
		return SQLDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME, KEY_PRICE}, null, null, null, null, null);
	}
	
}