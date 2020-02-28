package org.firstinspires.ftc.teamcode.MultiThread_Examples;


public class EncoderCallback implements CallbackInterface
{
    //You can create an classes you want and have them function as callbacks as long as they implement the CallbackInterface and include a method named onComplete()
    public boolean complete = false;

    public void onComplete()
    {
        System.out.println("It Ran");
        complete = true;
    }
}
