package com.example.dariusdavis.foodandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by CS Student on 3/29/2017.
 */

public class MedContent extends AppCompatActivity {
    // Used to display exercise types.
    Button exerciseB;
    // View breathing exercise.
    Intent breatheExer;

    @Override
    // View of design of app.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_content);
        // Get user intention of button choice.
        exerciseB=(Button)findViewById(R.id.button6);
        // Once user clicks button, display breathing activity.
        exerciseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breatheExer= new Intent(MedContent.this, BreatheEx.class);
                startActivity(breatheExer);
            }
        });
    }
}
