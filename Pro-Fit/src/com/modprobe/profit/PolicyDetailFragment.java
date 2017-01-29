package com.modprobe.profit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PolicyDetailFragment extends Fragment {

    public PolicyDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_policy_detail, container, false);
        Button clm = (Button)rootView.findViewById(R.id.claim);
        Button aply = (Button)rootView.findViewById(R.id.renew);
        
        clm.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
            	try{
                    String url = "9243422233";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + url));
                    getActivity().startActivity(intent);
                } catch (SecurityException e) {
                	Log.e("CALL", e.getMessage());
                    e.printStackTrace();
                }                
            }
        });
        
        aply.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
            	getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container, new PaymentFragment()).addToBackStack("pay").commit();
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

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.chat_view_menu, menu);
//    }

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