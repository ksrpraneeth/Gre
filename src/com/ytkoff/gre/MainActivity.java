package com.ytkoff.gre;

import com.ytkoff.gre.Aboutus.AboutUs;
import com.ytkoff.gre.Favourites.FavouritesFragment;
import com.ytkoff.gre.Home.HomeFragment;
import com.ytkoff.gre.NavigationDrawerFragment.NewContentView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ActionBarActivity implements NewContentView {
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = (Toolbar) findViewById(R.id.app_bar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		NavigationDrawerFragment navigationDrawer = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.fragment_navigation_drawer);
		navigationDrawer.setUp(R.id.fragment_navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout), toolbar, this);
	}

	@Override
	public void setNewContentView(int position) {
		Fragment fragment;
		FragmentManager fragmentManager = getSupportFragmentManager();
		switch (position) {
		case NavigationDrawerFragment.HOME_POS:
			fragment = new HomeFragment();
			break;
		case NavigationDrawerFragment.FAVROUITES_POS:
			fragment = new FavouritesFragment();

			break;
		case NavigationDrawerFragment.ABOUTUS_POS:
			fragment = new AboutUs();
			break;

		default:
			fragment = new HomeFragment();
			break;
		}
		if (fragment != null) {
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
		}

	}
}
