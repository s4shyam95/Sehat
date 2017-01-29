package com.modprobe.profit;

import java.util.List;

import com.tonicartos.superslim.GridSLM;
import com.tonicartos.superslim.LinearSLM;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class CompareListAdapter extends Adapter<CompareViewHolder> {

	private static final int VIEW_TYPE_HEADER = 0x01;
	private static final int VIEW_TYPE_CONTENT = 0x00;
	private static final int LINEAR = 0;
	private List<CompareItem> historyList;
	private int mHeaderDisplay;
	private boolean mMarginsFixed;
	private final Context mContext;

	public CompareListAdapter(Context context, List<CompareItem> historyList) {
		mContext = context;
		this.historyList = historyList;
	}

	@Override
	public int getItemCount() {
		return historyList.size();

	}

	@Override
	public void onBindViewHolder(CompareViewHolder contactViewHolder, int i) {
		final CompareItem item = historyList.get(i);
		final View itemView = contactViewHolder.itemView;
		final GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView
				.getLayoutParams());
		// Overrides xml attrs, could use different layouts too.
		
		
//		
		
		if (item.isHeader) {
			contactViewHolder.tvSubcat1.setText(item.title1);
//			contactViewHolder.tvSubcat.setText(item.date);
		} else {
			final CompareItem ci = historyList.get(i);
			AppController app = AppController.getInstance();
			contactViewHolder.tvCat1.setText(ci.text1);
			contactViewHolder.tvCat2.setText(ci.text2);
			contactViewHolder.tvSubcat1.setText(ci.title1.toUpperCase());
			contactViewHolder.tvSubcat2.setText(ci.title2);
//			contactViewHolder.tvCat.setText(ci._parent._parent._name + "");
//			contactViewHolder.tvSubcat.setText(ci._parent._name + "");
//			contactViewHolder.tvMisc.setText("Intensity " + ci._intensity
//					+ ", " + ci._duration + " minutes, "
//					+ Helper.getCals(ci._fitons) + " calories");
//			contactViewHolder.tvFittons.setText(ci._fitons + "");
			

		}

		// contactViewHolder.tvExpcal.setText(ci.expcal+"");

		// Calc expected calories
		// Top category exhertion level
		// Sub category exertion level
		// Duration

	}

	@Override
	public CompareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view; // =
					// LayoutInflater.from(arg0.getContext()).inflate(R.layout.history_item,
					// arg0, false);
		if (viewType == VIEW_TYPE_HEADER) {
			view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.compare_header_item, parent, false);
		} else {
			view = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.compare_desc_item, parent, false);
		}
		return new CompareViewHolder(view);
	}

	@Override
	public int getItemViewType(int position) {
		return historyList.get(position).isHeader ? VIEW_TYPE_HEADER
				: VIEW_TYPE_CONTENT;
	}

	public void setHeaderDisplay(int headerDisplay) {
		mHeaderDisplay = headerDisplay;
		notifyHeaderChanges();
	}

	public void setMarginsFixed(boolean marginsFixed) {
		mMarginsFixed = marginsFixed;
		notifyHeaderChanges();
	}

	private void notifyHeaderChanges() {
		for (int i = 0; i < historyList.size(); i++) {
			CompareItem item = historyList.get(i);
			if (item.isHeader) {
				notifyItemChanged(i);
			}
		}
	}

}
