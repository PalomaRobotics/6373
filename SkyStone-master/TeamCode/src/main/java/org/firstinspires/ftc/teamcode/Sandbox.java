package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Robot_Async.FourWheel;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;


@TeleOp(name = "Sandbox", group = "TeleOp")
public class Sandbox extends OpMode
{
    //sensor tests
    private DistanceSensor sensorRange;

    //END sensor tests




    int count = 0;
    //public static DcMotor Mark;


    public void init ()
    {
        //Mark = hardwareMap.dcMotor.get("mark");


        //sensor
        sensorRange = hardwareMap.get(DistanceSensor.class, "laser");
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;
        //END sensor
    }


    public void loop ()
    {

        //sensor
        telemetry.addData("value", sensorRange.getDistance(DistanceUnit.INCH));

        //END sensor

        count++;

        if(count == 1) //make sure this only runs once
        {
            //EncoderClass.RunToEncoderDegree(Mark, EncoderClass.MotorType.NeveRest40, 180, 0.5, true);
            //FourWheel.RunFourWheels(Mark,Mark,Mark,Mark);
            //Mark.setPower(.5);
        }

        telemetry.update();
    }
}
    // todo: write your code here
    
    