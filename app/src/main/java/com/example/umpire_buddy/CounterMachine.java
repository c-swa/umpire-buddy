package com.example.umpire_buddy;

/*
CounterMachine will store and count the number of Balls and Strikes.
Every time the CounterMachine gets an input from the UI, the Counter will increase the proper
variable by 1, and subsequently return a value.
 */
public class CounterMachine {
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

    //
    public int incrementValue(boolean isBall){
        if(isBall){
            ballCount++;
            return ballCount;
        } else {
            strikeCount++;
            return strikeCount;
        }

    }

}
