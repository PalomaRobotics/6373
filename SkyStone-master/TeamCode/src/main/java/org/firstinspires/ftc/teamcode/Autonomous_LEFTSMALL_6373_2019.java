package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import java.util.Date;

@Autonomous(name = "Autonomous_LEFTSMALL_6373_2019", group = "Autonomous")
public class Autonomous_LEFTSMALL_6373_2019 extends LinearOpMode {


    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    //ModernRoboticsI2cGyro gyro;   //Don't forget to import the proper library: import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;

    //GyroClass gyroObject; //create a variable capable of holding an object based off the GyroClass class


    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        //FL.setDirection(DcMotor.Direction.REVERSE);
        //BL.setDirection(DcMotor.Direction.REVERSE);


        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");

        //gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyroSens"); //THIS IS AN I2C DEVICE. Find a Gyro Sensor on the robot named gyroSens. gyroSens is the name that appears in the phones configuration

        //gyroObject = new GyroClass(gyro, FL, FR, BL, BR, 0.30, telemetry); //instantiate the gyroClass object

        //gyroObject.ResetHeading();

        waitForStart();
        //telemetry.addData("Time To Travel: ", "" + timer);


        //telemetry.addData("Main Started", ":)");
        //telemetry.update();

        double[] dirs = HolonomicDrive.RoboMoveXY(0.0, -1.0);

        long startTime = new Date().getTime();

        while (new Date().getTime() - startTime < 100) //run motors for 1 second
        {
            telemetry.addData("Loop", 1);
            telemetry.update();
            //EncoderClass.RunToEncoderDegreeAsync(FL, EncoderClass.MotorType.NeveRest40, 1800, 1.0, false);
            //EncoderClass.RunToEncoderDegreeAsync(FR, EncoderClass.MotorType.NeveRest40, 1800, 1.0, false);
            FL.setPower(dirs[0]);
            FR.setPower(dirs[1]);
            BL.setPower(dirs[2]);
            BR.setPower(dirs[3]);
        }

        FL.setPower(0.0);
        FR.setPower(0.0);


        dirs = HolonomicDrive.RoboMoveXY(-1.0, 0.0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < 1100) //run motors for 1 second
        {
            telemetry.addData("Loop", 1);
            telemetry.update();
            //EncoderClass.RunToEncoderDegreeAsync(FL, EncoderClass.MotorType.NeveRest40, 1800, 1.0, false);
            //EncoderClass.RunToEncoderDegreeAsync(FR, EncoderClass.MotorType.NeveRest40, 1800, 1.0, false);
            FL.setPower(dirs[0]);
            FR.setPower(dirs[1]);
            BL.setPower(dirs[2]);
            BR.setPower(dirs[3]);
        }


    }


}

