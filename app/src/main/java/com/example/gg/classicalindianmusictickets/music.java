package com.example.gg.classicalindianmusictickets;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class music extends AppCompatActivity {
    Button btTabla, btSitar;
     MediaPlayer mpTabla, mpSitar;
     int playing=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        btTabla = (Button) findViewById(R.id.btnPlayTabla);
        btSitar = (Button) findViewById(R.id.btnPlaySitar);
        btTabla.setOnClickListener(bTabla);
        btSitar.setOnClickListener(bSitar);
        mpTabla = new MediaPlayer();
        mpTabla = MediaPlayer.create(this, R.raw.tabla);
        playing = 0;
        mpSitar = new MediaPlayer();
        mpSitar = MediaPlayer.create(this, R.raw.sitar);
        playing = 0;
    }
        Button.OnClickListener bTabla = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing) {
                    case 0:
                        mpTabla.start();
                        playing = 1;
                        btTabla.setText("Pause Music");
                        break;
                    case 1:
                        mpTabla.pause();
                        playing = 0;
                        btTabla.setText("Play Music");
                        break;
                }
            }//slide 36
        };
        Button.OnClickListener bSitar = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing) {
                    case 0:
                        mpSitar.start();
                        playing = 1;
                        btSitar.setText("Pause Music");
                        break;
                    case 1:
                        mpSitar.pause();
                        playing = 0;
                        btSitar.setText("Play Music");
                        break;
                }
            }
        };
    }

