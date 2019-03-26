package com.agaharwar.audiovideo;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView video = (VideoView) findViewById(R.id.video);
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.kala);
        MediaController control = new MediaController(this);
        control.setAnchorView(video);
        video.setMediaController(control);
        video.start();

    }
}
