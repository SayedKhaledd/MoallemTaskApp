package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vid,vid2; MediaController m,m2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       vid = (VideoView)findViewById(R.id.videoView);
        vid2 = (VideoView)findViewById(R.id.videoView2);
       final ImageButton imgButton =(ImageButton)findViewById(R.id.imageButton9);
       final ImageButton imgButton2 =(ImageButton)findViewById(R.id.imageButton10);


        String path1 = "android.resource://com.example.test1/"+R.raw.v1;
        String path2 = "android.resource://com.example.test1/"+R.raw.v2;

        Uri u1 = Uri.parse(path1);
        Uri u2 = Uri.parse(path2);

        vid.setVideoURI(u1);
        vid2.setVideoURI(u2);
        vid.seekTo( 1 );
        vid2.seekTo( 1 );

        m = new MediaController(this);
         m2 = new MediaController(this);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgButton.setVisibility (View.GONE);

                playVideo(vid,m);
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imgButton2.setVisibility (View.GONE);

                playVideo(vid2,m2);
            }
        });



    }
    public void playVideo(VideoView v,MediaController m) {


        v.setMediaController(m);
v.start();



    }
}