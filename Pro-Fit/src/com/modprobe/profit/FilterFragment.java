package com.modprobe.profit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.appyvet.rangebar.RangeBar;

public class FilterFragment extends Fragment {

	public FilterFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_filter,
				container, false);
		
		RangeBar rb = (RangeBar)rootView.findViewById(R.id.coverage);
		final TextView rbtx = (TextView)rootView.findViewById(R.id.coverage_text);
		rb.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                    int rightPinIndex, String leftPinValue, String rightPinValue) {
            	rbtx.setText(leftPinValue + " to " + rightPinValue + " Lacs");
            }
        });
		
		RangeBar rb2 = (RangeBar)rootView.findViewById(R.id.premium_monthly);
		final TextView rbtx2 = (TextView)rootView.findViewById(R.id.premium_monthly_text);
		rb2.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                    int rightPinIndex, String leftPinValue, String rightPinValue) {
            	rbtx2.setText(leftPinValue + "000 to " + rightPinValue + "000 INR annually");
            }
        });
		
		RangeBar rb3 = (RangeBar)rootView.findViewById(R.id.hosp);
		final TextView rbtx3 = (TextView)rootView.findViewById(R.id.hosp_text);
		rb3.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                    int rightPinIndex, String leftPinValue, String rightPinValue) {
            	rbtx3.setText("Atleast " + leftPinValue + "0 to " + rightPinValue + "0 per day");
            }
        });
		
		RangeBar rb4 = (RangeBar)rootView.findViewById(R.id.covered_after_years);
		final TextView rbtx4 = (TextView)rootView.findViewById(R.id.covered_after_years_text);
		rb4.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                    int rightPinIndex, String leftPinValue, String rightPinValue) {
            	rbtx4.setText("After " + leftPinValue + " to " + rightPinValue + " years");
            }
        });
		
		Button clr = (Button)rootView.findViewById(R.id.clear);
		Button aply = (Button)rootView.findViewById(R.id.apply);
		
		clr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AppController.getInstance().filtered = false;
				getActivity().getSupportFragmentManager().beginTransaction().remove(FilterFragment.this).commit();
				
			}
		});
		
		aply.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AppController.getInstance().filtered = true;
//				getActivity().getSupportFragmentManager().beginTransaction().remove(FilterFragment.this).commit();
				getActivity().finish();
				
			}
		});
		
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

//	@Override
//	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//		inflater.inflate(R.menu.chat_view_menu, menu);
//	}

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// int id = item.getItemId();
	// if (id == R.id.view_presciption) {
	// FragmentManager fm = getActivity().getSupportFragmentManager();
	// fm.beginTransaction()
	// .replace(R.id.container,
	// new PrescriptionFragment(parentQuery._prescription))
	// .addToBackStack("PrescriptionFragment").commit();
	// return true;
	// }
	//
	// return super.onOptionsItemSelected(item);
	// }
}
