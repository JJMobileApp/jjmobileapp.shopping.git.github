package org.powerjack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.util.*;

public class Menu extends Activity {
	private TextView ttvChooseMenu;
	private Button btnNew;
	private Button btnBasket;
	private Button btnAbout;
	private Button btnExit;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ttvChooseMenu = (TextView) findViewById(R.id.menuTtvChooseMenu);
        btnNew = (Button) findViewById(R.id.menuBtnNew);
        btnBasket = (Button) findViewById(R.id.menuBtnBasket);
        btnAbout = (Button) findViewById(R.id.menuBtnAbout);
        btnExit = (Button) findViewById(R.id.menuBtnExit);
        
        btnNew.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getApplicationContext(), Nowy.class);
        		startActivity(intent);
        	}
        });
        
        btnBasket.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getApplicationContext(), Koszyk.class);
        		startActivity(intent);
        	}
        });
        
        btnAbout.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
    			Intent intent = new Intent(getApplicationContext(), About.class);
        		startActivity(intent);
        	}
        });
        
        btnExit.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		finish();
        	}
        });
    }
}