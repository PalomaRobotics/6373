package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Range_Sensor
{
    public static ModernRoboticsI2cRangeSensor Range = null;
    static DcMotor FL;
    static DcMotor FR;
    static DcMotor BL;
    static DcMotor BR;
    static double[] dirs = {0,0,0,0};
    public static void toRangeDir (int range,DistanceUnit unit, int x, int y)
    {
        dirs = HolonomicDrive.RoboMoveXY(x,-y);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
        while (Range.getDistance(unit)>range)
        {

        }
        dirs = HolonomicDrive.RoboMoveXY(0,0);
        FL.setPower(dirs[0]);
        FR.setPower(dirs[1]);
        BL.setPower(dirs[2]);
        BR.setPower(dirs[3]);
    }
}
