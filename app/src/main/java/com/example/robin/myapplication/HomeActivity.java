package com.example.robin.myapplication;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Check whether the user has already accepted
        SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE);

        boolean accepted = settings.getBoolean("accepted", true);
        if(!accepted){
            showLegalDisclaimer();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showLegalDisclaimer() {
        DialogFragment newFragment = new LegalDisclaimerFragment();
        newFragment.show(getFragmentManager(), "legal disclaimer");
    }

    /**
     * This method is called when the "Pregnant/assisting a pregnant lady" button is clicked.
     */
    public void pregnantWoman(View view) {
        final Context context = this;
        Button button = (Button) findViewById(R.id.button_pregnant);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, PregnantActivity.class);
                startActivity(intent);
            }
        });
    }

    //This method is called when the "Healthcare professional" button is clicked.
    public void healthcarePerson(View view) {
        final Context context = this;
        Button button = (Button) findViewById(R.id.button_healthcare);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, HealthcareActivity.class);
                startActivity(intent);
            }
        });
    }



}
