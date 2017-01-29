package com.modprobe.profit;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SearchFragment extends Fragment {
	View view;
	RecyclerView historyList;
	PolicyListAdapter hla;

	public SearchFragment() {
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("Oncreate","oncreate");
		view = inflater.inflate(R.layout.fragment_search, container, false);

		historyList = (RecyclerView) view
				.findViewById(R.id.policyList);
		historyList.addItemDecoration(new HistoryRecyclerViewItemSpacing(50));

		historyList.setHasFixedSize(true);
		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		historyList.setLayoutManager(llm);
		AppController app = AppController.getInstance();
		List<Policy> plist = new ArrayList<Policy>(app.plist);

		hla = new PolicyListAdapter(getActivity(), plist);
		historyList.setAdapter(hla);
		

		Button compareButton = (Button) view.findViewById(R.id.compareButton);
		final Context mContext = getActivity();
		compareButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(mContext, CompareActivity.class);
				startActivity(i);

			}
		});
		return view;
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		Log.e("Resume","Resume");
		hla = new PolicyListAdapter(getActivity(), new ArrayList<Policy>(AppController.getInstance().plist));
		historyList.setAdapter(hla);
		hla.notifyDataSetChanged();
	}

	
	
}
