package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;




public class Range_Sensor
{
    //public static ModernRoboticsI2cRangeSensor Range = AutonomousTest.Range;

    //i2c declaraions (Modern Robotics Range Ultrasonic Sensor)
    byte[] range1Cache; //The read will return an array of bytes. They are stored in this variable
    I2cAddr RANGE1ADDRESS = new I2cAddr(0x14); //Default I2C address for MR Range (7-bit)
    public static final int RANGE1_REG_START = 0x04; //Register to start reading
    public static final int RANGE1_READ_LENGTH = 2; //Number of byte to read
    public I2cDevice RANGE1;
    public I2cDeviceSynch RANGE1Reader;


    static DcMotor FL = AutonomousTest.FL;
    static DcMotor FR = AutonomousTest.FR;
    static DcMotor BL = AutonomousTest.BL;
    static DcMotor BR = AutonomousTest.BR;

    Telemetry telemetry;

    static double[] dirs = {0,0,0,0};

    public Range_Sensor(Telemetry telemetry, I2cDevice rangeSensorObject)
    {
        this.telemetry = telemetry;

        RANGE1 = rangeSensorObject;
        RANGE1Reader = new I2cDeviceSynchImpl(RANGE1, RANGE1ADDRESS, false);
        RANGE1Reader.engage();

    }

    public void toRangeDir (int range,DistanceUnit unit, int x, int y)
    {
        dirs = HolonomicDrive.RoboMoveXY(x,-y);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        //while (Range.getDistance(unit)>range)
        while (range1Cache[0] > range)
        {
            //telemetry.addData("unit>", Range.getDistance(unit));
            telemetry.addData("unit>", range1Cache[0] & 0xFF);
            telemetry.addData("range", range);
            telemetry.update();

        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
    }

/*
    public void fromRangeDir (int range,DistanceUnit unit, int x, int y)
    {
        dirs = HolonomicDrive.RoboMoveXY(x,-y);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        while (Range.getDistance(unit)<range)
        {

        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
    }

 */
}
