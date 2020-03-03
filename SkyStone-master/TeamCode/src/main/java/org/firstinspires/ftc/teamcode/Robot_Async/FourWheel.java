package org.firstinspires.ftc.teamcode.Robot_Async;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.EncoderClass;

public class FourWheel
{
    
    public static void RunFourWheels(DcMotor motor1, DcMotor motor2, DcMotor motor3, DcMotor motor4)
    {
        EncoderCallback encoderWatch1 = new EncoderCallback(); //Create an object which runs when the task completes
        EncoderCallback encoderWatch2 = new EncoderCallback();
        EncoderCallback encoderWatch3 = new EncoderCallback();
        EncoderCallback encoderWatch4 = new EncoderCallback();

        //create a new thread and call its run() method. Pass it the callback we created above so it knows what to run when the task completes        
        new Thread(new EncoderClass_Async(encoderWatch1, motor1, EncoderClass.MotorType.NeveRest40, 180, 0.5, true)).start();
        //new Thread(new EncoderClass_Async(encoderWatch2, motor2, EncoderClass.MotorType.NeveRest40, 37, 0.5, true)).start();
        //new Thread(new EncoderClass_Async(encoderWatch3, motor3, EncoderClass.MotorType.NeveRest40, 37, 0.5, true)).start();
        //new Thread(new EncoderClass_Async(encoderWatch4, motor4, EncoderClass.MotorType.NeveRest40, 37, 0.5, true)).start();
        
        //while(!encoderWatch1.complete || !encoderWatch2.complete || !encoderWatch3.complete || !encoderWatch4.complete ) //loop until all have finished
        while(!encoderWatch1.complete)
        {
            
        }
        
        //when you get here, it means all are done
    }
}
