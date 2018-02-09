package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by fatimazza on 2/9/18.
 */

// COMPLETED (4) Create SettingsFragment and extend PreferenceFragmentCompat

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        // COMPLETED (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

        /* Add 'general' preferences, defined in the XML file */
        addPreferencesFromResource(R.xml.pref_general);

    }

}
