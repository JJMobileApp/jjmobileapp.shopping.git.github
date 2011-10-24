package org.powerjack;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Koszyk extends ListActivity{
	
	//private final String DB_NAME = "Zakupy";
	//ArrayList<String> ListaZakupow = new ArrayList<String>();
	private DbAdapter db;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.koszyk);
		
		db.open();
		
		fillData();
		
		/*try{
			
			//SQLiteDatabase baza = null;
			//baza = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
			
			//baza.execSQL("CREATE TABLE IF NOT EXISTS Zakupy(Produkt VARCHAR, Cena VARCHAR)");
			//baza.execSQL("INSERT INTO Zakupy Values('" + edtProdukt.getText().toString() + "', '" + edtCena.getText().toString() + "')");
			
			//Cursor cursor = baza.rawQuery("SELECT * FROM Zakupy ORDER BY Produkt", null);
			
			/*
			if(cursor.moveToFirst()){
				do{
					String Produkt = cursor.getString(cursor.getColumnIndex("Produkt"));
					String Cena = cursor.getString(cursor.getColumnIndex("Cena"));
					ListaZakupow.add(0, Produkt + " " + Cena);
				}while(cursor.moveToNext());
			}
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.koszyktextview, R.id.KoszykTtvProduktPlusCena, ListaZakupow);
			setListAdapter(adapter);
			*/
			//edtProdukt.setText("");
			//edtCena.setText("");
			//edtProdukt.requestFocus();
			
			/*
			String produkt = edtProdukt.getText().toString() + " " + edtCena.getText().toString();
			ListaZakupow.add(0, produkt);
			iloscProduktow++;
			cenaRazem += Float.parseFloat(edtCena.getText().toString());
			ttvIloscProduktow.setText("Iloœæ produktów: " + Integer.toString(iloscProduktow));
			ttvCenaRazem.setText("Razem: " + Float.toString(cenaRazem));
			//ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.nowytextview, R.id.textview, ListaZakupow);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.nowytextview, R.id.textview, ListaZakupow);
			setListAdapter(adapter);
			edtProdukt.setText("");
			edtCena.setText("");
			edtProdukt.requestFocus();
			*/
		/*}
		catch (Exception ex){
			Log.d("Exception", ex.getMessage().toString());
		}*/
		
	}

	private void fillData()
	{
		
		Cursor itemsCursor = db.fetchAllItem();
		startManagingCursor(itemsCursor);
	
		String[] from = new String [] { DbAdapter.KEY_NAME };
		int[] to = new int[] { R.id.name };
		
		SimpleCursorAdapter items = new SimpleCursorAdapter(this,R.layout.list_item, itemsCursor, from, to); 
		setListAdapter(items);
		
	}

}