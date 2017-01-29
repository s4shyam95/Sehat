package com.modprobe.profit;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PolicyFragment extends Fragment {
	
	View view;
	Policy policy;
	public PolicyFragment(Context mContext, Policy ci) {
		this.policy = ci;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_policy, container, false);
		
		return view;
	}
	

}
