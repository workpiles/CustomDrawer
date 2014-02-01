package com.example.customdrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDrawerFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.drawer_list, container, false);

		Button btn = (Button)v.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Button Click", Toast.LENGTH_LONG).show();
				((MainActivity)getActivity()).getDrawer().closeDrawers();
			}
		});
		
		TextView text = (TextView)v.findViewById(R.id.textView3);
		text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Text Click", Toast.LENGTH_LONG).show();
				((MainActivity)getActivity()).getDrawer().closeDrawers();
			}
		});
		return v;
	}

}
