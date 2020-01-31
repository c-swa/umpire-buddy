package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Manager manager = new Manager();
    }

    //Method for onClick event of addBall button
    public void addBall(View view){

    }

    //Method for onClick event of addStrike button
    public void addStrike(View view){

    }

    //Method for onClick event of resetCounter button
    public void resetCounters(View view){

    }

    //Method for onClick event of exitApp button
    public void exitApp(View view){

    }
}
