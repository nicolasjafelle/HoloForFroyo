package com.holo.froyo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockFragment;
import com.holo.froyo.R;
import com.holo.froyo.dialog.MyAlertDialogFragment;

public class ViewOneFragment extends SherlockFragment {

	private Button button;
	
	public static Fragment newInstance() {
		return new ViewOneFragment();
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.views_one_fragment_layout, container, false);
		
		button = (Button) view.findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				MyAlertDialogFragment dialog = MyAlertDialogFragment.newInstance();
				dialog.show(getActivity().getSupportFragmentManager(), "dialog");

			}
		});
		
		return view; 
	}
}
