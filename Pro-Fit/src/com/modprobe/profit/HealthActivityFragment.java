package com.modprobe.profit;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

/**
 * A placeholder fragment containing a simple view.
 */
public class HealthActivityFragment extends Fragment {

	public HealthActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_health, container,
				false);
		ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
		SmartTabLayout viewPagerTab = (SmartTabLayout) rootView
				.findViewById(R.id.viewpagertab);
		viewPager.setOffscreenPageLimit(2);
		setup(viewPagerTab);

		
		FragmentPagerItems pages = new FragmentPagerItems(getActivity());
		pages.add(FragmentPagerItem.of(getString(R.string.tab_no_title),
				SearchFragment.class));
//		pages.add(FragmentPagerItem.of(getString(R.string.tab_no_title),
//				CompareFragment.class));
		pages.add(FragmentPagerItem.of(getString(R.string.tab_no_title),
				ChatViewFragment.class));
		pages.add(FragmentPagerItem.of(getString(R.string.tab_no_title),
				PolicyDetailFragment.class));
		pages.add(FragmentPagerItem.of(getString(R.string.tab_no_title),
				BingFragment.class));

		final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
				getActivity().getSupportFragmentManager(), pages);
		viewPager.setAdapter(adapter);
		viewPagerTab.setViewPager(viewPager);
		viewPagerTab.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		

		return rootView;

	}

	public void setup(SmartTabLayout layout) {

		final LayoutInflater inflater = LayoutInflater
				.from(layout.getContext());
		final Resources res = layout.getContext().getResources();

		layout.setCustomTabView(new SmartTabLayout.TabProvider() {
			@Override
			public View createTabView(ViewGroup container, int position,
					PagerAdapter adapter) {
				ImageView icon = (ImageView) inflater.inflate(
						R.layout.custom_tab_icon3, container, false);
				switch (position) {
				case 0:
					icon.setImageDrawable(res
							.getDrawable(R.drawable.search));
					break;
				case 1:
					icon.setImageDrawable(res.getDrawable(R.drawable.message));
					break;
				case 2:
					icon.setImageDrawable(res.getDrawable(R.drawable.user_profile2));
					break;
				case 3:
					icon.setImageDrawable(res
							.getDrawable(R.drawable.map));
					break;
				default:
					throw new IllegalStateException("Invalid position: "
							+ position);
				}
				return icon;
			}
		});
	}
}
