package org.firstinspires.ftc.teamcode.Robot_Async;


import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.MultiThread_Examples.CallbackInterface;
import org.firstinspires.ftc.teamcode.EncoderClass;

public class EncoderClass_Async implements Runnable
{

    CallbackInterface c;
    DcMotor motorObject;
    EncoderClass.MotorType motorType;
    int degree;
    double speed;
    boolean holdWhenFinished;

    public EncoderClass_Async(CallbackInterface c, DcMotor motorObject, EncoderClass.MotorType motorType, int degree, double speed, boolean holdWhenFinished)
    {
        //Constructor
        //To create a threadable object, you myst pass this constructor a reference to a callback object so I know what to run when the task completes
        this.c = c;
        this.motorObject = motorObject;
        this.motorType = motorType;
        this.degree = degree;
        this.speed = speed;
        this.holdWhenFinished = holdWhenFinished;
        
    }

    public void run()
    {
        //this is the code that will run in a new thread
        
        EncoderClass.RunToEncoderDegree(motorObject, motorType, degree, speed, holdWhenFinished);
        
        this.c.onComplete();
    }
    
    
}
