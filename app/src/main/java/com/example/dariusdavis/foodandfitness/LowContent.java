package com.example.dariusdavis.foodandfitness;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by CS Student on 3/29/2017.
 */

public class LowContent extends AppCompatActivity {
    // Gather chosen song type.
    MediaPlayer peaceSound;
    MediaPlayer tester;
    // For music purposes.
    Button sound;
    // Hold various songs.
    ArrayList playlist = new ArrayList();
    // Used to terminally song to resume later.
    int pause;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList <Integer> smoothJazzSongs = new ArrayList();
        smoothJazzSongs.add(R.raw.compassion);
        smoothJazzSongs.add(R.raw.deliverysanan);
        smoothJazzSongs.add(R.raw.loveland);

        tester = MediaPlayer.create(this,smoothJazzSongs.get(0));
        tester.start();

        // Randomly gather song.
        Random rand = new Random();
        int index = rand.nextInt(playlist.size());
        // Display view of app.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_content);
        // Select song.
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