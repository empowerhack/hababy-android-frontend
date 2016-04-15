package com.example.robin.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class LegalDisclaimerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
                // Use the Builder class for convenient dialog construction
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(R.string.legal_disclaimer_title);
        builder.setMessage(R.string.legal_disclaimer);
        builder.setPositiveButton(R.string.agree, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // and, if the user accept, you can execute something like this:
                // We need an Editor object to make preference changes.
                // All objects are from android.context.Context
                SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("accepted", true);
                // Commit the edits!
                editor.commit();

            }
        });
        builder.setNegativeButton(R.string.disagree, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent myIntent = new Intent(getActivity(), NotAcceptedLegalDisclaimerActivity.class);
                getActivity().startActivity(myIntent);
            }

        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
