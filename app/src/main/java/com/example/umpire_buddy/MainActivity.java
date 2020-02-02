package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CounterMachine counterMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterMachine = new CounterMachine();

        ((TextView) findViewById(R.id.ballDisplay)).setText(Integer.toString(counterMachine.getBallCount()));
        ((TextView) findViewById(R.id.strikeDisplay)).setText(Integer.toString(counterMachine.getStrikeCount()));

    }

    //Method for onClick event of addBall button
    public void addBall(View view){
        counterMachine.incrementValue(true);
        ((TextView) findViewById(R.id.ballDisplay)).setText(Integer.toString(counterMachine.getBallCount()));
    }

    //Method for onClick event of addStrike button
    public void addStrike(View view){
        counterMachine.incrementValue(false);
        ((TextView) findViewById(R.id.strikeDisplay)).setText(Integer.toString(counterMachine.getStrikeCount()));
    }

    //Method for onClick event of resetCounter button
    public void resetCounters(View view){
        counterMachine.resetCounts();
        ((TextView) findViewById(R.id.strikeDisplay)).setText(Integer.toString(counterMachine.getStrikeCount()));
        ((TextView) findViewById(R.id.ballDisplay)).setText(Integer.toString(counterMachine.getBallCount()));
    }

    //Method for onClick event of exitApp button
    public void exitApp(View view){
        finish();
    }
}
