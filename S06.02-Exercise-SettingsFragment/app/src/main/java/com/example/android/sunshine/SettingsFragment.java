package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by fatimazza on 2/9/18.
 */

// COMPLETED (4) Create SettingsFragment and extend PreferenceFragmentCompat

// Do steps 5 - 11 within SettingsFragment
// COMPLETED (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

public class SettingsFragment extends PreferenceFragmentCompat
    implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        // COMPLETED (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

        /* Add 'general' preferences, defined in the XML file */
        addPreferencesFromResource(R.xml.pref_general);

        // Do step 9 within onCreatePreference
        // COMPLETED (9) Set the preference summary on each preference that isn't a CheckBoxPreference

        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();

        PreferenceScreen prefScreen = getPreferenceScreen();
        int count = prefScreen.getPreferenceCount();

        for (int i = 0; i < count; i++) {
            Preference p = prefScreen.getPreference(i);

            if (!(p instanceof CheckBoxPreference)) {
                String value = sharedPreferences.getString(p.getKey(), "");
                setPreferenceSummary(p, value);
            }
        }

    }

    // COMPLETED (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference

    public void setPreferenceSummary(Preference preference, Object value) {

        String stringValue = value.toString();
        String key = preference.getKey();

        if (preference instanceof ListPreference) {
            /* For list preferences, look up the correct display value in */
            /* the preference's 'entries' list (since they have separate labels/values). */

            ListPreference listPreference = (ListPreference) preference;

            int prefIndex = listPreference.findIndexOfValue(stringValue);
            if (prefIndex >= 0) {
                //getting the Label which is associated with the Value
                listPreference.setSummary(listPreference.getEntries()[prefIndex]);
            }

        } else {
            // For other preferences, set the summary to the value's simple string representation.
            preference.setSummary(stringValue);
        }
    }

    // COMPLETED (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        //figure out which preference was changed
        Preference preference = findPreference(key);

        if (null != preference) {
            //updates the summary for the preference
            if (! (preference instanceof CheckBoxPreference)) {
                //is it same preference.getKey() and key?
                String value = sharedPreferences.getString(preference.getKey(), "");
                setPreferenceSummary(preference, value);
            }
        }
    }
}
