package com.example.exercise41;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        addPreferencesFromResource(R.xml.preferences);
    }
}
