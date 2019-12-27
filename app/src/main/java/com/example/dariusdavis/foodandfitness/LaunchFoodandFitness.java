package com.example.dariusdavis.foodandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by CS Student on 3/28/2017.
 */

public class LaunchFoodandFitness extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_food_and_fitness);
        setTitle("Food and Fitness");
    }
    //Called when the user clicks the button to log food
    public void LogFood (View view){
        //creates a new intent and starts a new blank activity
        Intent startNewActivity = new Intent(this, AddFoodActivity.class);
        startActivity(startNewActivity);
    }

    //Called when the user clicks the button to log exercise
    public void LogExercise (View view){
        //creates a new intent and starts a new blank activity
        Intent startNewActivity = new Intent(this, AddExerciseActivity.class);
        startActivity(startNewActivity);
    }
}
