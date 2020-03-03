package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Robot_Async.FourWheel;

@TeleOp(name = "Sandbox", group = "TeleOp")
public class Sandbox extends OpMode
{
    int count = 0;
    public static DcMotor Mark;
    public void init ()
    {
        Mark = hardwareMap.dcMotor.get("mark");
    }
    public void loop ()
    {
    
    count++;
    
    if(count == 1) //make sure this only runs once
    {
        //EncoderClass.RunToEncoderDegree(Mark, EncoderClass.MotorType.NeveRest40, 180, 0.5, true);
        //FourWheel.RunFourWheels(Mark,Mark,Mark,Mark);
        //Mark.setPower(.5);
    }
    
        
    }
}
    // todo: write your code here
    
    