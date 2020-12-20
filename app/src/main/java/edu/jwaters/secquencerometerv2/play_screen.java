package edu.jwaters.secquencerometerv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class play_screen extends AppCompatActivity implements SensorEventListener {


    TextView txtX, txtY, txtY1, txtZ, tvScore;
    private SensorManager manager;
    private Sensor sensor;
    private final double DEFALUT_FORWARD = 8.0;     // upper mag limit
    private final double DEFALUT_BACKWARD = 5.0;      // lower mag limit
    private final double NORTH_MOVE_LEFT = 1.0;     // upper mag limit
    private final double NORTH_MOVE_RIGHT = 1.0;      // lower mag limit
    boolean highLimit = false;
    private boolean flat = false;
    private boolean forward = false;
    private boolean backwards = false;
    private boolean left = false;
    private boolean right = false;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        txtX = findViewById(R.id.txtVXCoorDis);
        txtY = findViewById(R.id.txtVYCoorDis);
        txtY1 = findViewById(R.id.txtVY1CoorDis);
        txtZ = findViewById(R.id.txtVZCoorDis);
        tvScore = findViewById(R.id.tvCountDw);

        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(sensor.TYPE_ACCELEROMETER);

        OnPause();
        OnResume();

    }
    public void onSensorChanged(SensorEvent event) {
        // Called every x-ms by the system
        float x, y , z;
        Toast toastMessageFlat = Toast.makeText(this, "Flat", Toast.LENGTH_LONG);
        Toast toastMessageBottom = Toast.makeText(this, "Bottom", Toast.LENGTH_LONG);

        // gets the values of the sensors x y z
        x = Math.abs(event.values[0]);
        y = Math.abs(event.values[1]);
        z = Math.abs(event.values[2]);

        txtX.setText(String.valueOf(x));
        txtY.setText(String.valueOf(y));
        txtY1.setText(String.valueOf(-y));
        txtZ.setText(String.valueOf(z));


        // sets to flat
        if ((x > DEFALUT_FORWARD) && (highLimit == false)) {
            highLimit = true;
        }
        if ((x < DEFALUT_BACKWARD) && (highLimit == true)) {
            counter=0;
            flat=true;
            tvScore.setText(String.valueOf(counter));
            highLimit = false;
        }
        //  Get left movement
        if ((y < NORTH_MOVE_RIGHT) &&(x>=DEFALUT_FORWARD) &&(highLimit == false)) {
            highLimit = true;
        }
        if ((y > NORTH_MOVE_LEFT) && (highLimit == true)) {
            counter=2;
            left = true;
            tvScore.setText(String.valueOf(counter));
            highLimit = false;
        }
        //  Get right movement
        if ((-y < NORTH_MOVE_RIGHT) &&(x>=DEFALUT_FORWARD) &&(highLimit == false)) {
            highLimit = true;
        }
        if ((-y > NORTH_MOVE_LEFT) && (highLimit == true)) {
            counter=3;
            right = true;
            tvScore.setText(String.valueOf(counter));
            highLimit = false;
        }
        // sets to flat
        if ((z > DEFALUT_FORWARD) && (highLimit == false)) {
            highLimit = true;
        }
        if ((z < DEFALUT_BACKWARD) && (highLimit == true)) {
            counter=1;
            tvScore.setText(String.valueOf(counter));
            highLimit = false;
        }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not in use
    }
    // app running but not on screen
    protected void OnPause() {
        super.onPause();
        // turns off the Listener to save power
        manager.unregisterListener(this);

    }

    // when app is running on the screen
    protected void OnResume() {
        super.onResume();
        // turns on the sensor
        manager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void Next(View view) {
        Intent summaryActivity = new Intent(view.getContext(),Game_Over.class);
        startActivity(summaryActivity);
    }
}