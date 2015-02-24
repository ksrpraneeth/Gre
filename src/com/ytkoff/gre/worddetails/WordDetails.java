package com.ytkoff.gre.worddetails;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.ytkoff.gre.R;

public class WordDetails extends ActionBarActivity {
	Toolbar toolbar;
	private RevealLayout mRevealLayout;
	private boolean mIsAnimationSlowDown = true;
	private boolean mIsBaseOnTouchLocation = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_details);
		toolbar = (Toolbar) findViewById(R.id.app_bar);
		mRevealLayout = (RevealLayout) findViewById(R.id.reveal_layout);
		setSupportActionBar(toolbar);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		initRevealLayout();

	}

	private void initRevealLayout() {
		if (mIsBaseOnTouchLocation) {
			mRevealLayout.setOnClickListener(null);
			mRevealLayout.setOnTouchListener(new View.OnTouchListener() {
				@SuppressLint("NewApi")
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
						Log.d("SingleChildActivity", "x: " + event.getX()
								+ ", y: " + event.getY());
						if (mIsAnimationSlowDown) {
							mRevealLayout.next((int) event.getX(),
									(int) event.getY(), 500);
						} else {
							mRevealLayout.next((int) event.getX(),
									(int) event.getY());
						}
						return true;
					}
					return false;
				}
			});
		} else {
			 mRevealLayout.setOnTouchListener(null);
			mRevealLayout.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (mIsAnimationSlowDown) {
						mRevealLayout.next(2000);
					} else {
						mRevealLayout.next();
					}
				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

}
