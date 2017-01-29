package com.modprobe.profit;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompareViewHolder extends ViewHolder {
	TextView tvSubcat1;
	TextView tvCat1;
	TextView tvSubcat2;
	TextView tvCat2;
	
	public CompareViewHolder(View itemView) {
		super(itemView);
		tvSubcat1 = (TextView) itemView.findViewById(R.id.textViewSubcat1);
		tvCat1 = (TextView) itemView.findViewById(R.id.textViewCat1);
		tvSubcat2 = (TextView) itemView.findViewById(R.id.textViewSubcat2);//change
		tvCat2 = (TextView) itemView.findViewById(R.id.textViewCat2);//change
		
	}

}
