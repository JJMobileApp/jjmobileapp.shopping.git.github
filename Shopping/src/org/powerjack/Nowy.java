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
	//private ListView lstLista;
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
		
		//db = new DbAdapter();
		//db.open();
		
		btnExit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
				
	}
}