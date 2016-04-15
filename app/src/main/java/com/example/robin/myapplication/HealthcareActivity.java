package com.example.robin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HealthcareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //This method is called when the "Specialist" button is clicked.
    public void specialistPerson(View view) {
        final Context context = this;
        Button button = (Button) findViewById(R.id.button_specialist);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, SpecialistActivity.class);
                startActivity(intent);
            }
        });
    }

    //This method is called when the "Specialist" button is clicked.
    public void doctorPerson(View view) {
        final Context context = this;
        Button button = (Button) findViewById(R.id.button_normaldoctor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, NormalDoctorActivity.class);
                startActivity(intent);
            }
        });
    }

}
