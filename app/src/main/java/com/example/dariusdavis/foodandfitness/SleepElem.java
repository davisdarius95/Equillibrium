package com.example.dariusdavis.foodandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CS Student on 3/29/2017.
 */

public class SleepElem extends AppCompatActivity {
    // Used to indicate relaxation phases.
    Button lowB;
    Button medB;
    Button highB;
    // Go to specfic activity based on user choice.
    Intent lowInfo;
    Intent medInfo;
    Intent highInfo;

    @Override
    // Design of layout.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_elem);
        // Based on chosen button, go to content.
        lowB=(Button)findViewById(R.id.button);
        medB=(Button)findViewById(R.id.button2);
        highB=(Button)findViewById(R.id.button3);
        // Music phase.
        lowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowInfo= new Intent (SleepElem.this, MusicType.class);
                startActivity(lowInfo);
            }
        });
        // Excercise phase.
        medB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medInfo= new Intent (SleepElem.this, MedContent.class);
                startActivity(medInfo);
            }
        });
        // Seek professional help phase.
        highB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highInfo= new Intent (SleepElem.this, HighContent.class);
                startActivity(highInfo);
            }
        });

    }
}
