package com.example.dariusdavis.foodandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CS Student on 3/29/2017.
 */

public class MusicType extends AppCompatActivity {
    // Used to obtain user intention.
    Button sjazz;
    Button mediate;
    Button classical;

    // Go to specfic activity chosen by user.
    Intent smoothjazzM;
    Intent mediationM;
    Intent classicalM;

    @Override
    // Design view of app.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_type);
        // If user clicks jazz, play jazz music.
        sjazz = (Button) findViewById(R.id.button4);
        mediate = (Button) findViewById(R.id.button9);
        classical = (Button) findViewById(R.id.button13);

        sjazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoothjazzM = new Intent(MusicType.this, sJazzM.class);
                startActivity(smoothjazzM);
            }
        });

        mediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediationM = new Intent(MusicType.this, MeditateM.class);
                startActivity(mediationM);
            }
        });

        classical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classicalM = new Intent(MusicType.this, sJazzM.class);
                startActivity(classicalM);
            }
        });




    }

}
