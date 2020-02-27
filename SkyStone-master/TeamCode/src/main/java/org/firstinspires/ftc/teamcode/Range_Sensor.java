package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;




public class Range_Sensor
{
   // public static ModernRoboticsI2cRangeSensor Range = AutonomousTest.Range;

    ModernRoboticsI2cRangeSensor Range;

    Telemetry telemetry;

    static double[] dirs = {0,0,0,0};

    public Range_Sensor(Telemetry telemetry, ModernRoboticsI2cRangeSensor rangeSensorObject)
    {
        this.telemetry = telemetry;
        this.Range = rangeSensorObject;
    }

    public void toRangeDir (int range,DistanceUnit unit, int x, int y,DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor)
    {
        dirs = HolonomicDrive.RoboMoveXY(x,-y);
        frontLeftMotor.setPower(dirs[0]);
        frontRightMotor.setPower(dirs[1]);
        backLeftMotor.setPower(dirs[2]);
        backRightMotor.setPower(dirs[3]);
        while (Range.getDistance(unit)>range)
        {
            telemetry.addData("unit>", Range.getDistance(unit));
            telemetry.addData("range", range);
            telemetry.update();

        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        frontLeftMotor.setPower(dirs[0]);
        frontRightMotor.setPower(dirs[1]);
        backLeftMotor.setPower(dirs[2]);
        backRightMotor.setPower(dirs[3]);
    }

    public void PollSensor()
    {
        while (true)
        {
            telemetry.addData("Distance", Range.getDistance(DistanceUnit.INCH));
            telemetry.update();
        }
    }

public void fromRangeDir (int range,DistanceUnit unit, int x, int y,DcMotor frontLeftMotor, DcMotor frontRightMotor, DcMotor backLeftMotor, DcMotor backRightMotor)
    {
        dirs = HolonomicDrive.RoboMoveXY(x,-y);
        frontLeftMotor.setPower(dirs[0]);
        frontRightMotor.setPower(dirs[1]);
        backLeftMotor.setPower(dirs[2]);
        backRightMotor.setPower(dirs[3]);
        while (Range.getDistance(unit)<range)
        {
            telemetry.addData("unit<", Range.getDistance(unit));
            telemetry.addData("range", range);
            telemetry.update();

        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        frontLeftMotor.setPower(dirs[0]);
        frontRightMotor.setPower(dirs[1]);
        backLeftMotor.setPower(dirs[2]);
        backRightMotor.setPower(dirs[3]);
    }
}
