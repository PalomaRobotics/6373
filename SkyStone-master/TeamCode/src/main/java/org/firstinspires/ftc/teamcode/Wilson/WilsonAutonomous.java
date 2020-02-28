package org.firstinspires.ftc.teamcode.Wilson;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;

import org.firstinspires.ftc.teamcode.GyroClass;

@Autonomous (name = "WilsonAutonomous", group = "Autonomous")
public class WilsonAutonomous extends LinearOpMode {

    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    ModernRoboticsI2cGyro gyro;   //Don't forget to import the proper library: import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;

    GyroClass gyroObject; //create a variable capable of holding an object based off the GyroClass class



    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);


        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");

        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyroSens"); //THIS IS AN I2C DEVICE. Find a Gyro Sensor on the robot named gyroSens. gyroSens is the name that appears in the phones configuration

        gyroObject = new GyroClass(gyro,FL,FR,BL,BR,0.30,telemetry); //instantiate the gyroClass object

        gyroObject.ResetHeading();

        waitForStart();
        //telemetry.addData("Time To Travel: ", "" + timer);

        while(true)
        {
            gyroObject.StraightLineUpdate();
        }


    }


}
