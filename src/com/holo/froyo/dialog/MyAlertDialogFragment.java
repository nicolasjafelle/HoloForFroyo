package com.holo.froyo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.holo.froyo.R;

public class MyAlertDialogFragment extends DialogFragment {

	public static MyAlertDialogFragment newInstance() {
		MyAlertDialogFragment frag = new MyAlertDialogFragment();
		Bundle args = new Bundle();
		frag.setArguments(args);
		return frag;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light_Dialog);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    builder.setView(inflater.inflate(R.layout.dialog_signin, null));
	    
	 // Add action buttons
	    builder.setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // sign in the user ...
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        return builder.create();

	    // OR you can return simple dialogs...
//		return new AlertDialog.Builder(getActivity()).setIcon(R.drawable.ic_launcher).setTitle("Titulo").setPositiveButton(R.string.hello_world, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int whichButton) {
//			}
//		}).setNegativeButton(R.string.app_name, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int whichButton) {
//			}
//		}).create();
	}
}
