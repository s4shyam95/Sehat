package com.modprobe.profit;

import java.io.IOException;
import java.util.List;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.Fitness;

public class HealthActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		TextView toolbarTitle = (TextView) toolbar
				.findViewById(R.id.toolbar_title);
		Typeface khandBold = Typeface.createFromAsset(AppController
				.getInstance().getAssets(), "fonts/dinroundweb.ttf");
		toolbarTitle.setTypeface(khandBold);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle(null);
		getSupportActionBar().setElevation(0);
		HealthActivityFragment healthActivityFragment = new HealthActivityFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		fragmentTransaction.add(R.id.container, healthActivityFragment)
				.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.miCompose2:
			finish();
			break;

		case R.id.filter:
			Intent in3 = new Intent(this, FilterActivity.class);
			startActivity(in3);
			break;

		case R.id.miProfile:
			Intent in2 = new Intent(this, SelectLangaugeActivity.class);
			startActivity(in2);
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
