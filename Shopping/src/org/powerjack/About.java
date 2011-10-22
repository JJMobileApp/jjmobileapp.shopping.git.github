package org.powerjack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class About extends Activity{
	private Button btnExit;	
	/*
	 * To jest testowy komentarz
	 * */
	
	@Override
	protected void onCreate(Bundle icicle){
		super.onCreate(icicle);
		setContentView(R.layout.about);
		
		btnExit = (Button)findViewById(R.id.aboutBtnExit);
		btnExit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
	}
}
