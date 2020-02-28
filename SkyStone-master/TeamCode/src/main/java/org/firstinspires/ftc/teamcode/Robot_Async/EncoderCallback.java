package org.firstinspires.ftc.teamcode.Robot_Async;
import org.firstinspires.ftc.teamcode.MultiThread_Examples.CallbackInterface; //include a link to the interface we need to use

public class EncoderCallback implements CallbackInterface
{
    private boolean complete = false;
    
    public void onComplete()
    {
        //this method runs when the async task finishes
        complete = true; //set the flag to indicate it is done
    }
    
}
