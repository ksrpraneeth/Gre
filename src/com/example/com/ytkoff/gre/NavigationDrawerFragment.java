package com.example.com.ytkoff.gre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class NavigationDrawerFragment extends Fragment {
	ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private boolean userLearnedDrawer;
	private boolean mFromOnSavedInstance;

	public NavigationDrawerFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_navigation_drawer, container,
				false);
	}

	public void setUp(DrawerLayout drawerlayout, Toolbar toolbar) {
		// TODO Auto-generated method stub
		mDrawerLayout = drawerlayout;
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout,
				toolbar, R.string.drawer_open, R.string.drawer_close) {

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
	}

}
