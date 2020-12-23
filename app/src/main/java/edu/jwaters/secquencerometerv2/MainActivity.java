package edu.jwaters.secquencerometerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessController;

public class MainActivity extends AppCompatActivity {
    View imageTop, imageLeft, imageRight, imageBottom;
    CountDownTimer timer;
    TextView counter;
    int sequenceCount = 4, n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageTop = findViewById(R.id.imgTop);
        imageLeft = findViewById(R.id.imgLeft);
        imageRight = findViewById(R.id.imgRight);
        imageBottom = findViewById(R.id.imgBottom);

    }

    public void StartGame(final View view) {

         counter =findViewById(R.id.tvCountDw);
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("Starting in: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counter.setText("done!");
                Sequence();
               //topColorChange();
               // leftColorChange();
               // RightColorChange();
              //  BottomColorChange();

                Intent summaryActivity = new Intent(view.getContext(),play_screen.class);

                startActivity(summaryActivity);
            }
        }.start();


        //topColorChange();


    }


    public void topColorChange(){
     /*    new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("Starting in: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                }*/



                imageLeft.setBackgroundResource(R.color.colorOldSchool);



    }

    public void leftColorChange(){
                imageLeft.setBackgroundResource(R.color.colorOldSchool);

    }
    public void RightColorChange(){
            imageLeft.setBackgroundResource(R.color.colorOldSchool);


    }
    public void BottomColorChange(){
            imageLeft.setBackgroundResource(R.color.colorOldSchool);



    }

    public void Sequence(){
      // for (int i = 0; i < sequenceCount; i++) {
           n = RandomNumber(4);
          // int x = RandomNumber(sequenceCount);
          // int x = n;
           Toast.makeText(this, "Number = " + n, Toast.LENGTH_SHORT).show();
/*

           if (x == 1)
               topColorChange();
           else if (x == 2)
               leftColorChange();
           else if (x == 3)
               RightColorChange();
           else if (x == 4)
               BottomColorChange();
*/

            switch (n) {
                case 1:
                    topColorChange();
                    break;
                case 2:
                    leftColorChange();
                    break;
                case 3:
                    RightColorChange();
                    break;
                case 4:
                    BottomColorChange();
                    break;
                default:
                    break;
            }   // end switch
      // }
    }


    private int RandomNumber(int maxValue)
    {
        return ((int) ((Math.random() * maxValue) + 1));
    }
}