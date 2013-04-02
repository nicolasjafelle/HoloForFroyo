package com.holo.froyo.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.actionbarsherlock.app.SherlockFragment;
import com.holo.froyo.R;

public class ViewThreeFragment extends SherlockFragment {

	private ListView listView;
	
	public static Fragment newInstance() {
		return new ViewThreeFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.views_three_fragment_layout, container, false);
		
		listView = (ListView) view.findViewById(R.id.listview);

		// create the grid item mapping
		String[] from = new String[] { "col_1", "col_2" };
		int[] to = new int[] { android.R.id.text1, android.R.id.text2 };

		// prepare the list of all records
		List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 20; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("col_1", "col_1_item_" + i);
			map.put("col_2", "col_2_item_" + i);
			fillMaps.add(map);
		}

		listView.setFastScrollEnabled(true);
		listView.setAdapter(new SimpleAdapter(this.getActivity(), fillMaps, android.R.layout.simple_list_item_1, from, to));

		
		
		return view;
	}
}
