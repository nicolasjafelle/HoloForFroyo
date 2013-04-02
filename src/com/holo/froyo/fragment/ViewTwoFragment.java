package com.holo.froyo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.holo.froyo.R;

public class ViewTwoFragment extends SherlockFragment {

	public static Fragment newInstance() {
		return new ViewTwoFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.views_two_fragment_layout, container, false);
	}
}
