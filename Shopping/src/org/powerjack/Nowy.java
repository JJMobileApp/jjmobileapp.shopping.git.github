package org.powerjack;

import android.app.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;
import android.text.*;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Nowy extends ListActivity{
	private Button btnExit;
	private Button btnDodaj;
	private EditText edtProdukt;
	private EditText edtCena;
	private ListView lstLista;
	private TextView ttvIloscProduktow;
	private TextView ttvCenaRazem;
	private int iloscProduktow;
	private float cenaRazem;
	private TextView ttvProdukty;
	//private final String DB_NAME = "Zakupy";
	private DbAdapter db;
	
	ArrayList<String> ListaZakupow = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nowy);
		
		btnExit = (Button)findViewById(R.id.NowyBtnExit);
		btnDodaj = (Button)findViewById(R.id.NowyBtnDodaj);
		edtProdukt = (EditText)findViewById(R.id.NowyEdtProdukt);
		edtCena = (EditText)findViewById(R.id.NowyEdtCena);
		ttvIloscProduktow = (TextView)findViewById(R.id.NowyTtvIloscProduktow);
		ttvCenaRazem = (TextView)findViewById(R.id.NowyTtvRazem);
		//ttvProdukty = (TextView)findViewById(R.id.NowyTtvProdukty);
		
		db = new DbAdapter();
		db.open();
		
		
		btnDodaj.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if((edtProdukt.getText().length() == 0) || (edtCena.getText().length() == 0)){
					Toast toast = Toast.makeText(getApplicationContext(), "Proszê podaæ produkt i cenê", 1000);
					toast.show();					
				}
				else{
					try{
						
						db.createItem(edtProdukt.getText().toString(), edtCena.getText().toString());
						finish();
						
						//SQLiteDatabase baza = null;
						//baza = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
					
						//baza.execSQL("CREATE TABLE IF NOT EXISTS Zakupy(Produkt VARCHAR, Cena VARCHAR)");
						//baza.execSQL("INSERT INTO Zakupy Values('" + edtProdukt.getText().toString() + "', '" + edtCena.getText().toString() + "')");
						
						//Cursor cursor = baza.rawQuery("SELECT * FROM Zakupy ORDER BY Produkt", null);
						
						//if(cursor.moveToFirst()){
						//	do{
						//		String Produkt = cursor.getString(cursor.getColumnIndex("Produkt"));
						//		String Cena = cursor.getString(cursor.getColumnIndex("Cena"));
						//		ListaZakupow.add(0, Produkt + " " + Cena);
						//	}while(cursor.moveToNext());
						//}
						//
						//ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.nowytextview, R.id.textview, ListaZakupow);
						// setListAdapter(adapter);
						// edtProdukt.setText("");
						// edtCena.setText("");
						// edtProdukt.requestFocus();
						
						
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
					}
					catch (Exception ex){
						Log.d("Exception", ex.getMessage().toString());
					}
				}
			}
		});
	
		btnExit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
}
