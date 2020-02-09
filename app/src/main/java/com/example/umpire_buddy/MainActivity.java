package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CounterMachine counterMachine;

    //Button Instantiations
    public Button addBall;
    public Button addStrike;
    public Button resetCounts;
    public Button exitApp;
   // public Button about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterMachine = new CounterMachine(this);

        ((TextView) findViewById(R.id.ballDisplay)).setText(Integer.toString(counterMachine.getBallCount()));
        ((TextView) findViewById(R.id.strikeDisplay)).setText(Integer.toString(counterMachine.getStrikeCount()));

        //Sets Button Objects to the equivalent button in the UI
        addBall = (Button) findViewById(R.id.addBall);
        addStrike = (Button) findViewById(R.id.addStrike);
        resetCounts = (Button) findViewById(R.id.resetCounters);
        exitApp = (Button) findViewById(R.id.exitApp);

        //Sets addBall click listener
        addBall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addBall(view);
            }
        });
        //Sets addStrike onClick listener
        addStrike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addStrike(view);
            }
        });
        //Sets resetCounts onClick listener
        resetCounts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                resetCounters(view);
            }
        });
        //Sets exitApp onClick listener
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp(v);
            }
        });

    }

    //Sets passed button as inactive
    public void setInactive(Button button){
        button.setEnabled(false);
    }

    //Sets passed button as active
    public void setActive(Button button){
        button.setEnabled(true);
    }

    //Method for onClick event of aboutPageButton


    //Method for onClick event of addBall button
    public void addBall(View view){
        counterMachine.incrementValue(addBall);
        ((TextView) findViewById(R.id.ballDisplay)).setText(Integer.toString(counterMachine.getBallCount()));
    }

    //Method for onClick event of addStrike button
    public void addStrike(View view){
        counterMachine.incrementValue(addStrike);
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
