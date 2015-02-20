package com.ytkoff.gre;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends ActionBarActivity {
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
		navigationDrawer.setUp(R.id.fragment_navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout),
				toolbar);
	}
}
