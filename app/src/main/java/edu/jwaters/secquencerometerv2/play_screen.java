package edu.jwaters.secquencerometerv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class play_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);


    }

    public void Next(View view) {
        Intent summaryActivity = new Intent(view.getContext(),Game_Over.class);
        startActivity(summaryActivity);
    }
}