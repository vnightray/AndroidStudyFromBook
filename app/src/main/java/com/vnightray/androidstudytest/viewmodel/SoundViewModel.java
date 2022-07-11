package com.vnightray.androidstudytest.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.vnightray.androidstudytest.model.BeatBox;
import com.vnightray.androidstudytest.model.Sound;

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox){
        mBeatBox = beatBox;
    }

    public Sound getSound(){
        return mSound;
    }

    public void setSound(Sound sound){
        mSound = sound;
        notifyChange();
    }

    public void onButtonClicked(){
        mBeatBox.play(mSound);
    }

    @Bindable
    public String getTitle(){
        return mSound.getName();
    }

}
