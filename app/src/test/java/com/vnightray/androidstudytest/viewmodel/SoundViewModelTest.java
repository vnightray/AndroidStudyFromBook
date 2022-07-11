package com.vnightray.androidstudytest.viewmodel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import com.vnightray.androidstudytest.model.BeatBox;
import com.vnightray.androidstudytest.model.Sound;

import org.junit.Before;
import org.junit.Test;

public class SoundViewModelTest {

    private BeatBox mBeatBox;

    private Sound mSound;

    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle(){
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }
}