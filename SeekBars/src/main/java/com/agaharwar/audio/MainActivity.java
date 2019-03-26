package com.agaharwar.audio;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import android.media.AudioManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Boolean playingStatus = false;
    MediaPlayer mPlayer;
    AudioManager manager;
//    MediaPlayer mObj = ;


    public void pauseClicked(View view){
        if (playingStatus == true){
            mPlayer.pause();
            Log.i("AudioControl", "Audio Paused");
            Toast.makeText(MainActivity.this, "Audio Paused", Toast.LENGTH_SHORT).show();
            playingStatus = false;
        } else {
            Log.i("AudioControl", "Already Paused");
            Toast.makeText(MainActivity.this, "Already Paused", Toast.LENGTH_SHORT).show();
        }
    }

    public void playClicked(View view){
        if (playingStatus == false){
            mPlayer.start();
            Log.i("AudioControl", "Audio Started");
            playingStatus = true;
            Toast.makeText(MainActivity.this, "Audio started", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("AudioControl", "Already Running");
            Toast.makeText(MainActivity.this, "Already running", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SeekBar audioCntrl;

        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(this, R.raw.phone);
        manager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = manager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int totalMediaTime = mPlayer.getDuration();
        SeekBar volControl = (SeekBar) findViewById(R.id.volBar);
        audioCntrl = (SeekBar) findViewById(R.id.seekBar);
        audioCntrl.setMax(totalMediaTime);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                audioCntrl.setProgress(mPlayer.getCurrentPosition());

            }
        }, 0, 1000);
        volControl.setMax(maxVol);
        volControl.setProgress(curVol);
        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SeekBar", "Seekbar value: " + progress);
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }
        });
        audioCntrl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("AudioBar", "AudioBar value: " + progress);
                mPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
