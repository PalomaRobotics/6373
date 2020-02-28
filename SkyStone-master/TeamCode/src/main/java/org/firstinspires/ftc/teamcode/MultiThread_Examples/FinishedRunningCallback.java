package org.firstinspires.ftc.teamcode.MultiThread_Examples;


public class FinishedRunningCallback implements CallbackInterface
{
    //You can create as many classes as you want and have them function as callbacks as long as they implement the CallbackInterface and include a method named onComplete()
    //This example is for some generic hypothetical class that runs when the asychronous calls in main finish running
    public boolean complete = false;

    public void onComplete()
    {
        System.out.println("It Ran");
        complete = true;
    }
}
