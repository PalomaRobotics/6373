package org.firstinspires.ftc.teamcode;
//package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.MultiThread_Examples.CallbackInterface;

public class EncoderClass_Async implements Runnable
{

    CallbackInterface c;
    DcMotor motorObject;
    int encValue;
    double speed;
    boolean holdWhenFinished;

    public EncoderClass_Async(CallbackInterface c, DcMotor motorObject, int encValue, double speed, boolean holdWhenFinished)
    {
        //Constructor
        //To create a threadable object, you myst pass this constructor a reference to a callback object so I know what to run when the task completes
        this.c = c;
        this.motorObject = motorObject;
        this.encValue = encValue;
        this.speed = speed;
        this.holdWhenFinished = holdWhenFinished;
        
    }

    public void run()
    {
        //this is the code that will run in a new thread
        
        EncoderClass.RunToEncoderValue(motorObject, encValue, speed, holdWhenFinished);
        
        this.c.onComplete();
    }
    
    
}
