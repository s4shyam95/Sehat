package com.modprobe.profit;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class CompareFragment extends Fragment {

	View view;

	// public static final in V

	public CompareFragment() {
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.compare_fragment, container, false);
		
		Button buyBut = (Button) view.findViewById(R.id.buyButton);
		
		buyBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PaymentFragment healthActivityFragment = new PaymentFragment();
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager
						.beginTransaction();
				fragmentTransaction.add(R.id.container, healthActivityFragment).commit();
				
			}
		});
		
		
		RecyclerView historyList = (RecyclerView) view
				.findViewById(R.id.historyList);
		

		historyList.setHasFixedSize(true);
		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		historyList.setLayoutManager(llm);
		
		List<CompareItem> items = new ArrayList<CompareItem>();

		items.add(new CompareItem("TOP FEATURES"));
		items.add(new CompareItem("Hospital Room Eligibility","Upto Rs 4 K per day for room","There are no sublimits on availing rooms under hospitalization", false));
		items.add(new CompareItem("Day Care Treatments","All day care treatmentsm","140 listed treatments", true));
		items.add(new CompareItem("Ambulance Cover","Upto Rs 1500 per hospitalization","Upto Rs 2500 per hospitalization", false));
		items.add(new CompareItem("Bonus on No Claim","Incremental cover up to Rs 50 K added for every claim-free year upto a cumulative maximum of Rs 2.5 Lacs","Incremental cover up to Rs 40 K added for every claim-free year upto a cumulative maximum of Rs 2 Lacs", true));
		items.add(new CompareItem("IN-PATIENT CARE"));
		items.add(new CompareItem("Alternate Medicine","Coverage of upto Rs 35 K for utilizing ayurveda, unani or other alternate medicine","Coverage of upto Rs 15 K for utilizing ayurveda, unani or other alternate medicine", true));
		items.add(new CompareItem("Share Claim Payments","Full claims payment by Insure","Mandatory payment of 20% of all claims", true));
		items.add(new CompareItem("Network Hospitals Covered","4900","1985", true));
		items.add(new CompareItem("COVERAGE TERMS"));
		items.add(new CompareItem("Restoration of Cover","Unlimited amount will be reinstated for a non-related illnes","No reinstatement of Sum Insured for a non-related illness", true));
		items.add(new CompareItem("Pre Existing Conditions","There is a waiting period of 3 years for coverage on conditions declared ","There is a waiting period of 4 years for coverage on conditions declared", true));
		items.add(new CompareItem("MATERNITY COVERS"));
		items.add(new CompareItem("Maternity Cover","3 kids","This plan doesn't provide coverage for maternity", true));

		CompareListAdapter hla = new CompareListAdapter(getActivity(), items);
		historyList.setAdapter(hla);
		
		return view;
	}

}
