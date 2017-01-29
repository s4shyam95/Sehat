package com.modprobe.profit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PaymentFragment extends Fragment implements LocationListener {

	private Context mContext;

	public PaymentFragment() {
		this.mContext = getActivity();
	}

	PaymentFragment(Context context) {

		this.mContext = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		this.mContext = getActivity();
		View view = inflater.inflate(R.layout.fragment_payment, container, false);
		final WebView map = (WebView) view.findViewById(R.id.pay);

		map.setWebViewClient(new WebViewClient() {
			public void onPageFinished(WebView w, String url) {

			}
		});
		map.getSettings().setJavaScriptEnabled(true);
		map.loadUrl("file:///android_asset/pay.html");
		return view;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}