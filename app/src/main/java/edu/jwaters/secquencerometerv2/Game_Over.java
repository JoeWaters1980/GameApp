package edu.jwaters.secquencerometerv2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static edu.jwaters.secquencerometerv2.R.layout.activity_game__over;

public class Game_Over extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_game__over);
    }

    public void Scores(View view) {
        Intent summaryActivity = new Intent(view.getContext(),hi_score_screen.class);
        startActivity(summaryActivity);
    }
}