package com.example.dariusdavis.foodandfitness;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by CS Student on 3/29/2017.
 */

public class MeditateM extends AppCompatActivity {

    // Gather specfic song type.
    MediaPlayer peaceSound;
    @Override
    // Design of app for view.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_jazz);
        peaceSound = MediaPlayer.create(this, R.raw.sleep1);
    }

    // When pushed, play relax music.
    public void playMus (View v){
        peaceSound.start();
    }

    // When chosen, pause music.
    public void pauseMus (View v) {
        peaceSound.pause();
    }

    // When selected, pause music.
    public void stopMus(View v) {
        peaceSound.stop();
        // Used to not erase song once stopped mutiple times.
        peaceSound=MediaPlayer.create(this,R.raw.sleep1);
    }
}

