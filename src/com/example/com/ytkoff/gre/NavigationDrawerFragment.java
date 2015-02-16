package com.example.com.ytkoff.gre;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.NoCopySpan.Concrete;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class NavigationDrawerFragment extends Fragment {
	public static final String FILE_NAME = "navigationDrawerConstants";
	ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private boolean userLearnedDrawer;
	private boolean mFromOnSavedInstance;

	public NavigationDrawerFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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

	public void saveToPrefrences(Context context, String preferenceName,
			String preferenceValue) {
		SharedPreferences prefrences = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefrences.edit();
		editor.putString(preferenceName, preferenceValue);
		editor.apply();
	}

	public String readFromPrefrences(Context context, String preferenceName,
			String defaultValue) {
		SharedPreferences prefrences = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		return prefrences.getString(preferenceName, defaultValue);
	}
}
