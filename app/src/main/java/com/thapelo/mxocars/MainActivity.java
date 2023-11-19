package com.thapelo.mxocars;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        // Created a new Timer object called splashTimer
        Timer splashTimer = new Timer();
        splashTimer.schedule( new TimerTask() {
            @Override
            /*
             * On Run the timer opens up the next Activity in set seconds
             */
            public void run() {
                Intent splashIntent = new Intent( MainActivity.this, Welcome.class );
                startActivity( splashIntent );
                finish();
            }

        }, 2000 );


    }
}

