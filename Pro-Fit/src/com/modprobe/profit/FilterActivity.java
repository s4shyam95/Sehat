package com.modprobe.profit;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		TextView toolbarTitle = (TextView) toolbar
				.findViewById(R.id.toolbar_title);
		Typeface khandBold = Typeface.createFromAsset(AppController
				.getInstance().getAssets(), "fonts/dinroundweb.ttf");
		toolbarTitle.setTypeface(khandBold);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(null);
		getSupportActionBar().setElevation(0);
		// TODO open filter fragment
		if (AppController.getInstance().plist.size() == 4) {
			AppController.getInstance().plist.remove(3);
			AppController.getInstance().plist.remove(2);

		}
		FilterFragment healthActivityFragment = new FilterFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(R.id.container, healthActivityFragment)
				.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}

}
