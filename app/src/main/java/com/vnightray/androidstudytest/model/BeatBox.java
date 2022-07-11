package com.vnightray.androidstudytest.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {

    public static final String TAG = "BeatBox";

    public static final String SOUNDS_FLODER = "sample_sounds";

    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;

    private List<Sound> mSounds = new ArrayList<>();

    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
            // list方法列出指定目录下的所有文件名
            soundNames = mAssets.list(SOUNDS_FLODER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (Exception e){
            Log.e(TAG, "Could not list assets", e);
            return;
        }

        for (String filename : soundNames) {
            try {
                String assetPath = SOUNDS_FLODER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException e){
                Log.e(TAG, "Could not load sound " + filename, e);
            }
        }
    }

    private void load(Sound sound) throws IOException {

        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd, 1);
        sound.setSoundId(soundId);

    }


    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if (soundId == null){
            return;
        }

        Log.i(TAG, "当前触发声音： " + sound.getSoundId());

        // 参数： 音频id， 左音量， 右音量， 优先级（无效）， 是否循环， 播放速率
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);

    }

    public void release(){
        mSoundPool.release();
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
