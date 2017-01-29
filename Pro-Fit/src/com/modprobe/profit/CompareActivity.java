package com.modprobe.profit;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

public class CompareActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compare);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		TextView toolbarTitle = (TextView) toolbar
				.findViewById(R.id.toolbar_title);
		Typeface khandBold = Typeface.createFromAsset(AppController
				.getInstance().getAssets(), "fonts/dinroundweb.ttf");
		toolbarTitle.setTypeface(khandBold);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(null);
		getSupportActionBar().setElevation(0);
		CompareFragment healthActivityFragment = new CompareFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(R.id.container, healthActivityFragment).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}


}
