package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CounterMachine counterMachine;

    //Button Instantiations
    public Button addBall;
    public Button addStrike;
    public Button resetCounts;
    public Button exitApp;
    public Button about;


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
        about = (Button) findViewById(R.id.aboutButton);

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
        exitApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                exitApp(v);
            }
        });
        //Sets aboutButton onClick listener
        about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showAboutScreen();
            }
        });

    }

    //Allows change of screen when user taps about button.
    public void showAboutScreen(){
        Intent intent = new Intent(this, aboutScreen.class);

        TextView app_name = (TextView) findViewById(R.id.app_name);
        TextView app_display_name = (TextView) findViewById(R.id.app_name_disp);
        TextView author = (TextView) findViewById(R.id.author);
        TextView author_name = (TextView) findViewById(R.id.author_name);
        TextView version = (TextView) findViewById(R.id.version);
        TextView date = (TextView) findViewById(R.id.published);

        startActivity(intent);
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
