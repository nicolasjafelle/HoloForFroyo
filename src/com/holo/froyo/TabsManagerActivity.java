package com.holo.froyo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.holo.froyo.fragment.ViewOneFragment;
import com.holo.froyo.fragment.ViewThreeFragment;
import com.holo.froyo.fragment.ViewTwoFragment;

public class TabsManagerActivity extends SherlockFragmentActivity implements TabListener {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
	
	private List<Fragment> fragments;
	private String[] locations;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		locations = getResources().getStringArray(R.array.views);
		fragments = new ArrayList<Fragment>();
		
		fragments.add(ViewOneFragment.newInstance());
		fragments.add(ViewTwoFragment.newInstance());
		fragments.add(ViewThreeFragment.newInstance());
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				getSupportActionBar().setSelectedNavigationItem(position);
			}
		});

		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			getSupportActionBar().addTab(getSupportActionBar().newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
		}

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		menu.add("Save").setIcon(R.drawable.ic_action_share).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//
//		SubMenu subMenu = menu.addSubMenu(0, 0, 2, null);
//
//		subMenu.add(0, 5, 5, "Share").setIcon(R.drawable.ic_action_share);
//
//		subMenu.add(0, 6, 6, "About").setIcon(R.drawable.ic_action_about);
//
//		MenuItem subMenuItem = subMenu.getItem();
//		subMenuItem.setIcon(R.drawable.ic_menu_moreoverflow_normal_holo_light);
//		subMenuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
//
//		return true;
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.tabs_manager_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		 // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.tabs_manager_share:
	            Toast.makeText(TabsManagerActivity.this, "SHARE!", Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.tabs_manager_settings:
	        	Toast.makeText(TabsManagerActivity.this, "SETTINGS!", Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.tabs_manager_about_us:
	        	Toast.makeText(TabsManagerActivity.this, "ABOUT US!", Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("tab", "issue_fixed");
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}
	
	// ** SECTION PAGER ADAPTER **
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return locations.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return locations[position];
		}
	}


}
