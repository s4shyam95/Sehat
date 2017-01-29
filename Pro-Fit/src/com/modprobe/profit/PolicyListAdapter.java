package com.modprobe.profit;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.tonicartos.superslim.GridSLM;

public class PolicyListAdapter extends Adapter<PolicyViewHolder> {

	private static final int VIEW_TYPE_HEADER = 0x01;
	private static final int VIEW_TYPE_CONTENT = 0x00;
	private static final int LINEAR = 0;
	private List<Policy> historyList;
	private int mHeaderDisplay;
	private boolean mMarginsFixed;
	private final Context mContext;

	public PolicyListAdapter(Context context, List<Policy> historyList) {
		mContext = context;
		this.historyList = historyList;
	}

	@Override
	public int getItemCount() {
		return historyList.size();

	}

	@Override
	public void onBindViewHolder(PolicyViewHolder contactViewHolder, int i) {
		final Policy item = historyList.get(i);
		final View itemView = contactViewHolder.itemView;
		final GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView
				.getLayoutParams());
		// Overrides xml attrs, could use different layouts too.
		
		final Policy ci = historyList.get(i);
		Log.e("Name",contactViewHolder.toString());
		AppController app = AppController.getInstance();
		
		contactViewHolder.cover.setText("₹ " + ci.insuranceCoverage + " COVER");
		contactViewHolder.name.setText(ci.name + "");
		contactViewHolder.premium.setText("₹ " + ci.premiumAmount + " PREMIUM");
		contactViewHolder.itemm1.setText("Maternity Cover");
		contactViewHolder.itemm2.setText("Hospital Room");
		contactViewHolder.itemm3.setText("Ambulance Cover");
		contactViewHolder.item1.setImageDrawable(mContext.getResources().getDrawable(R.drawable.maternity));
		contactViewHolder.item2.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hospital));
		contactViewHolder.item3.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ambulance));
		switch(i){
		case 0:
			contactViewHolder.logo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hdfc));
			break;
		case 1:
			contactViewHolder.logo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hdfc1));
			break;
		case 2:
			contactViewHolder.logo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hdfc2));
			break;
		case 3:
			contactViewHolder.logo.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hdfc2));
			break;
		}
		contactViewHolder.click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//open PolicyFragment with ci as parameter to constructor, goodluck
				Log.e("Click",ci.toString());
				PolicyFragment pf = new PolicyFragment(mContext,ci);
			}
		});
		
		
		
		
		
		
		
		

		// contactViewHolder.tvExpcal.setText(ci.expcal+"");

		// Calc expected calories
		// Top category exhertion level
		// Sub category exertion level
		// Duration

	}

	@Override
	public PolicyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view; // =
					// LayoutInflater.from(arg0.getContext()).inflate(R.layout.history_item,
					// arg0, false);

		view = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.policy_item, parent, false);
		return new PolicyViewHolder(view);
	}

	@Override
	public int getItemViewType(int position) {
		return VIEW_TYPE_CONTENT;
	}

}
