package com.example.com.ytkoff.gre;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class NavigationDrawerFragment extends Fragment {
	public static final String FILE_NAME = "navigationDrawerConstants";
	public static final String KEY_USER_LEARNED_DRAWER = "userlearneddrawer";

	ActionBarDrawerToggle mDrawerToggle;
	private DrawerLayout mDrawerLayout;
	private boolean userLearnedDrawer;
	private boolean mFromOnSavedInstance;
	private View containerview;
	private RecyclerView recyclerView;
	private MenuAdapter adapter;

	public NavigationDrawerFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		userLearnedDrawer = Boolean.valueOf(readFromPrefrences(getActivity(),
				KEY_USER_LEARNED_DRAWER, "false"));
		if (savedInstanceState != null) {
			mFromOnSavedInstance = true;

		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View layout = inflater.inflate(R.layout.fragment_navigation_drawer,
				container, false);
		recyclerView = (RecyclerView) layout.findViewById(R.id.drawer_list);
		adapter = new MenuAdapter(getActivity(), getMenuData());

		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		recyclerView.setAdapter(adapter);
		recyclerView.addOnItemTouchListener(new CyclerTouchListener(
				getActivity(), recyclerView, new ClickListener() {

					@Override
					public void onLongClick(View v, int position) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onClick(View v, int position) {
						// TODO Auto-generated method stub
						System.out.println("view clicked " + position);
					}
				}));

		return layout;
	}

	public void setUp(int fragmentNavigationDrawer, DrawerLayout drawerlayout,
			Toolbar toolbar) {
		// TODO Auto-generated method stub
		containerview = getActivity().findViewById(fragmentNavigationDrawer);
		mDrawerLayout = drawerlayout;
		mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout,
				toolbar, R.string.drawer_open, R.string.drawer_close) {

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				getActivity().invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				if (!userLearnedDrawer) {
					userLearnedDrawer = true;
					saveToPrefrences(getActivity(), KEY_USER_LEARNED_DRAWER,
							userLearnedDrawer + "");

				}
				getActivity().invalidateOptionsMenu();
			}

		};

		if (!userLearnedDrawer && !mFromOnSavedInstance) {
			mDrawerLayout.openDrawer(containerview);
		}
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerLayout.post(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mDrawerToggle.syncState();
			}
		});

	}

	public List<MenuList> getMenuData() {
		int[] imageRes = { R.drawable.ic_home, R.drawable.ic_home,
				R.drawable.ic_home };
		String[] titles = { "Home", "Favroites", "About Us" };
		List<MenuList> menudatalist = new ArrayList<MenuList>();
		for (int i = 0; i < titles.length & i < imageRes.length; i++) {
			MenuList menu = new MenuList();
			menu.setImageResId(imageRes[i]);
			menu.setTitle(titles[i]);
			menudatalist.add(menu);
		}
		return menudatalist;
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

	class CyclerTouchListener implements RecyclerView.OnItemTouchListener {
		private GestureDetector gestureDetector;
		ClickListener clicklistner;

		CyclerTouchListener(Context context, RecyclerView view,
				final ClickListener clicklistner) {
			this.clicklistner = clicklistner;
			gestureDetector = new GestureDetector(context,
					new GestureDetector.SimpleOnGestureListener() {
						@Override
						public boolean onSingleTapUp(MotionEvent e) {
							// TODO Auto-generated method stub
							return super.onSingleTapUp(e);
						}

						@Override
						public void onLongPress(MotionEvent e) {
							// TODO Auto-generated method stub
							View child = recyclerView.findChildViewUnder(
									e.getX(), e.getY());
							if (child != null && clicklistner != null) {
								clicklistner.onLongClick(child,
										recyclerView.getChildPosition(child));
							}
							super.onLongPress(e);
						}
					});
		}

		@Override
		public boolean onInterceptTouchEvent(RecyclerView arg0, MotionEvent e) {
			// TODO Auto-generated method stub

			View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
			if (child != null && clicklistner != null) {
				clicklistner.onClick(child, arg0.getChildPosition(child));
				System.out.println("touch intercepted");
			}
			return false;
		}

		@Override
		public void onTouchEvent(RecyclerView arg0, MotionEvent arg1) {
			// TODO Auto-generated method stub

		}

	}

	public static interface ClickListener {
		public void onClick(View v, int position);

		public void onLongClick(View v, int position);
	}
}
