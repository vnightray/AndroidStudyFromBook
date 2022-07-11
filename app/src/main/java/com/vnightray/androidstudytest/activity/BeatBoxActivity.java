package com.vnightray.androidstudytest.activity;

import androidx.fragment.app.Fragment;

import com.vnightray.androidstudytest.fragment.BeatBoxFragment;

public class BeatBoxActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
