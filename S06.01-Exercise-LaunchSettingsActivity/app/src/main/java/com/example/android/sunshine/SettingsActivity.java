package com.example.android.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    // COMPLETED (1) Add new Activity called SettingsActivity using Android Studio wizard
    // Do step 2 in SettingsActivity
    // TODO (2) Set setDisplayHomeAsUpEnabled to true on the support ActionBar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
}
