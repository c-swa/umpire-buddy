package com.example.umpire_buddy;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*
CounterMachine will store and count the number of Balls and Strikes.
Every time the CounterMachine gets an input from the UI, the Counter will increase the proper
variable by 1, and subsequently return a value.
 */
public class CounterMachine {
    private MainActivity mainActivity;
    private int ballCount;
    private int strikeCount;

    CounterMachine(MainActivity main){
        mainActivity = main;
    }

    //Returns ballCount.
    public int getBallCount(){
        return ballCount;
    }
    //Returns strikeCount.
    public int getStrikeCount(){
        return strikeCount;
    }

    //When told to Reset values to default, resetCounts() sets both ballCount and strikeCount to 0.
    public void resetCounts(){
        ballCount = 0;
        strikeCount = 0;
        mainActivity.setActive(mainActivity.addBall);
        mainActivity.setActive(mainActivity.addStrike);
    }

    //On the basis of which button is pressed, either the ball counter will
    public int incrementValue(Button button){
        if(button == mainActivity.addBall){
            ballCount++;
            if (ballCount >= 4) {
                openWalkDialog();
                mainActivity.setInactive(mainActivity.addBall);
                mainActivity.setInactive(mainActivity.addStrike);
            }
            return ballCount;
        } else if (button == mainActivity.addStrike) {
            strikeCount++;
            if(strikeCount >= 3) {
                openOutDialog();
                mainActivity.setInactive(mainActivity.addStrike);
                mainActivity.setInactive(mainActivity.addBall);
            }
            return strikeCount;
        }
        else {
            return -1;
        }

    }

    //When the ball count reaches its' limit, this dialog box should open.
    public void openWalkDialog(){
        DisplayDialog displayDialog =  new DisplayDialog("WALK!", "Player walks, too many balls.");
        displayDialog.show(mainActivity.getSupportFragmentManager(), "walk dialog");
    }

    //When the strike count reaches its' limit, this dialog box should open.
    private void openOutDialog(){
        DisplayDialog displayDialog = new DisplayDialog("OUT!", "Player strikes out!");
        displayDialog.show(mainActivity.getSupportFragmentManager(), "out dialog");
    }
}
