package com.example.umpire_buddy;

import androidx.appcompat.app.AppCompatActivity;

/*
CounterMachine will store and count the number of Balls and Strikes.
Every time the CounterMachine gets an input from the UI, the Counter will increase the proper
variable by 1, and subsequently return a value.
 */
public class CounterMachine extends AppCompatActivity {
    private int ballCount;
    private int strikeCount;

    //Constructor
    CounterMachine(){
        resetCounts();
    }

    //Increments ballCount

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
    }

    //On the basis of which button is pressed, either the ball counter will
    public int incrementValue(boolean isBall){
        if(isBall){
            ballCount++;
            if (ballCount >= 4)
                openDialog();
            return ballCount;
        } else {
            strikeCount++;
            if(strikeCount >= 3)
                openOutDialog();
            return strikeCount;
        }

    }

    //When the ball count reaches its' limit, this dialog box should open.
    private void openDialog(){
        DisplayDialog displayDialog =  new DisplayDialog();
        displayDialog.show(getSupportFragmentManager(), "walk dialog");
    }

    //When the strike count reaches its' limit, this dialog box should open.
    private void openOutDialog(){
        DisplayDialog displayDialog = new DisplayDialog();
        displayDialog.show(getSupportFragmentManager(), "out dialog");
    }

}
