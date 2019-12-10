package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;



import java.util.Date;

@Autonomous(name = "Autonomous_BLUE_6373_2019", group = "Autonomous")
public class Autonomous_BLUE_6373_2019 extends LinearOpMode {


    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;
    //I2cDevice rightDistance;
    byte[] range1Cache;
    I2cAddr RANGE1ADDRESS = new I2cAddr(0x14); //Default I2C address for MR Range (7-bit)
    public static final int RANGE1_REG_START = 0x04; //Register to start reading
    public static final int RANGE1_READ_LENGTH = 2; //Number of byte to read
    public I2cDevice RANGE1;
    public I2cDeviceSynch RANGE1Reader;
    //ModernRoboticsI2cGyro gyro;   //Don't forget to import the proper library: import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;

    //GyroClass gyroObject; //create a variable capable of holding an object based off the GyroClass class
    int dist1 = 120;
    int Time2 = 500;
    int Time3 = 500;
    int Time4 = 1000;
    int Time5 = 400;
    int Time6 = 400;
    int Time7 = 3200;
    int Time8 = 750;
    @Override
    public void runOpMode() throws InterruptedException {
        FL = hardwareMap.dcMotor.get("FL");
        BL = hardwareMap.dcMotor.get("BL");
        //FL.setDirection(DcMotor.Direction.REVERSE);
        //BL.setDirection(DcMotor.Direction.REVERSE);


        FR = hardwareMap.dcMotor.get("FR");
        BR = hardwareMap.dcMotor.get("BR");
        RANGE1 = hardwareMap.i2cDevice.get("MR_RANGE");
        RANGE1Reader = new I2cDeviceSynchImpl(RANGE1, RANGE1ADDRESS, false);
        RANGE1Reader.engage();
        //gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyroSens"); //THIS IS AN I2C DEVICE. Find a Gyro Sensor on the robot named gyroSens. gyroSens is the name that appears in the phones configuration

        //gyroObject = new GyroClass(gyro, FL, FR, BL, BR, 0.30, telemetry); //instantiate the gyroClass object

        //gyroObject.ResetHeading();

        waitForStart();
        //telemetry.addData("Time To Travel: ", "" + timer);


        //telemetry.addData("Main Started", ":)");
        //telemetry.update();

        while(true) {
            double[] dirs = HolonomicDrive.RoboMoveXY(1.0, 0);


            while (range1Cache[0] > 0 && range1Cache[0] < dist1) //run motors for 1 second
            {


                FL.setPower(dirs[0]);
                FR.setPower(dirs[1]);
                BL.setPower(dirs[2]);
                BR.setPower(dirs[3]);

                range1Cache = RANGE1Reader.read(RANGE1_REG_START, RANGE1_READ_LENGTH);
            }

            FL.setPower(0.0);
            FR.setPower(0.0);
        }
/*
        long startTime = new Date().getTime();
        dirs = HolonomicDrive.RoboMoveXY(0, 1);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time2) //run motors for 1 second
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
        dirs = HolonomicDrive.RoboMoveXY(1, 0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time3) //run motors for 1 second
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
        dirs = HolonomicDrive.RoboMoveXY(0, 0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time4) //run motors for 1 second
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
        //CODE NEEDED TO GRAB THE BLOCK HERE!!!!
        dirs = HolonomicDrive.RoboMoveXY(0, -1.0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time5) //run motors for 1 second
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
        dirs = HolonomicDrive.RoboMoveXY(-1.0, 0.0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time6) //run motors for 1 second
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
        dirs = HolonomicDrive.RoboMoveXY(0.0, 1.0);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time7) //run motors for 1 second
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
        dirs = HolonomicDrive.RoboRotate(1);
        startTime = new Date().getTime();

        while (new Date().getTime() - startTime < Time8) //run motors for 1 second
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

 */
    }



}

