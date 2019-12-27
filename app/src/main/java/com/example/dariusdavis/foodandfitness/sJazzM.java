package com.example.dariusdavis.foodandfitness;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by CS Student on 3/29/2017.
 */

public class sJazzM extends AppCompatActivity {
    // Gather specfic song type.
    MediaPlayer peaceSound;
    MediaPlayer tester;
    @Override
    // Design of app for view.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_jazz);
        ArrayList<Integer> smoothJazzSongs = new ArrayList();
        smoothJazzSongs.add(R.raw.compassion);
        smoothJazzSongs.add(R.raw.deliverysanan);
        smoothJazzSongs.add(R.raw.loveland);
        smoothJazzSongs.add(R.raw.himalayatomeditate);
        smoothJazzSongs.add(R.raw.immerse);
        smoothJazzSongs.add(R.raw.moolaprayer);
        smoothJazzSongs.add(R.raw.returntopeace);
//        Collections.shuffle(smoothJazzSongs);

        tester = MediaPlayer.create(this,smoothJazzSongs.get(0));
        peaceSound = MediaPlayer.create(this, R.raw.sleep1);
    }

    // When pushed, play relax music.
    public void playMus (View v){
        tester.start();
    }

    // When chosen, pause music.
    public void pauseMus (View v) {
        tester.pause();
    }

    // When selected, pause music.
    public void stopMus(View v) {
        tester.stop();
        // Used to not erase song once stopped mutiple times.
        tester=MediaPlayer.create(this,R.raw.compassion);
    }

}