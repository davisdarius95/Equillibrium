package com.example.dariusdavis.foodandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainMenu extends AppCompatActivity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        setTitle("Main Menu");
  }

  public void ffMenu (View view){
      Intent startNewActivity = new Intent(this, LaunchFoodandFitness.class);
      startActivity(startNewActivity);
  }

  public void SleepElement (View view){
      Intent startNewActivity = new Intent(this, SleepElem.class);
      startActivity(startNewActivity);
  }
}
