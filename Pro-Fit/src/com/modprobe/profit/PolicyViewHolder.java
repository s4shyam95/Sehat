package com.modprobe.profit;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class PolicyViewHolder extends ViewHolder {
	ImageView logo;
	TextView cover;
	TextView premium;
	TextView name;
	ImageView item1;
	ImageView item2;
	ImageView item3;
	TextView itemm1;
	TextView itemm2;
	TextView itemm3;
	Button click;
	RatingBar rb;
	Button buy;
	CheckBox cb;
	
	public PolicyViewHolder(View itemView) {
		super(itemView);
		Log.e("boo",itemView.toString());
		this.logo = (ImageView) itemView.findViewById(R.id.logoiv);
		this.name = (TextView) itemView.findViewById(R.id.nametv);
		this.cover = (TextView) itemView.findViewById(R.id.covertv);
		premium = (TextView) itemView.findViewById(R.id.premiumtv);
		itemm1 = (TextView) itemView.findViewById(R.id.item1tv);
		itemm2 = (TextView) itemView.findViewById(R.id.item2tv);
		itemm3 = (TextView) itemView.findViewById(R.id.item3tv);
		item1 = (ImageView) itemView.findViewById(R.id.item1iv);
		item2 = (ImageView) itemView.findViewById(R.id.item2iv);
		item3 = (ImageView) itemView.findViewById(R.id.item3iv);
		click = (Button) itemView.findViewById(R.id.click);
		
	}

}
