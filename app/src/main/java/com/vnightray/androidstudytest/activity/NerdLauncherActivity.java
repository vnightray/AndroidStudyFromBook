package com.vnightray.androidstudytest.activity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import com.vnightray.androidstudytest.R;
import com.vnightray.androidstudytest.fragment.NerdLaunchFragment;

public class NerdLauncherActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return NerdLaunchFragment.newInstance();
    }

}